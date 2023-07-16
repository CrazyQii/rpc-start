package top.hanlinqi.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import top.hanlinqi.core.enums.ProtocolConstants;
import top.hanlinqi.core.enums.RequestType;
import top.hanlinqi.core.protocol.Header;
import top.hanlinqi.core.protocol.MessageProtocol;
import top.hanlinqi.core.common.RpcRequest;
import top.hanlinqi.core.common.RpcResponse;
import top.hanlinqi.core.serializer.ISerializer;
import top.hanlinqi.core.serializer.SerializerManager;

import java.util.List;
import java.util.Objects;

/**
 * @program: RpcDecoder
 * @description: 反序列化
 * @author: hanLinQi
 * @create: 2023-03-08 10:31
 **/
@Slf4j
public class RpcDecoder extends ByteToMessageDecoder {

    /**
     * +----------------------------------------------+
     * | 魔数 2byte | 序列化算法 1byte | 请求类型 1byte  |
     * +----------------------------------------------+
     * | 消息 ID 32byte     |      数据长度 4byte       |
     * +----------------------------------------------+
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        log.info("start to decode data");
        if (byteBuf.readableBytes() < ProtocolConstants.HEAD_TOTAL_LEN) {
            // 可读的数组长度小于协议长度，直接抛弃
            return;
        }

        // 标记魔数位置
        byteBuf.markReaderIndex();

        // 魔术
        short magic = byteBuf.readShort();
        if (magic != ProtocolConstants.MAGIC) {
            throw new IllegalArgumentException("非法魔数！" + magic);
        }

        // 序列化算法
        byte serializerType = byteBuf.readByte();
        // 请求类型
        byte reqType = byteBuf.readByte();
        // 消息id
        long requestId = byteBuf.readLong();
        // 数据长度
        int length = byteBuf.readInt();
        if (byteBuf.readableBytes() < length) {
            // 可读的数据长度小于 请求体长度 直接丢弃并重置 读指针位置
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] data = new byte[length];
        byteBuf.readBytes(data);

        Header header = new Header();
        header.setMagic(magic);
        header.setReqType(reqType);
        header.setSerialType(serializerType);
        header.setLength(length);
        header.setRequestId(requestId);

        ISerializer serializer = SerializerManager.getSerializer(serializerType);
        RequestType rt = RequestType.findByCode(reqType);
        if (rt == null) {
            return;
        }

        switch (rt) {
            case REQUEST:
                RpcRequest request = serializer.deSerializer(data, RpcRequest.class);
                if (Objects.nonNull(request)) {
                    MessageProtocol<RpcRequest> protocol = new MessageProtocol<>();
                    protocol.setHeader(header);
                    protocol.setContent(request);
                    list.add(protocol);
                }
                break;
            case RESPONSE:
                RpcResponse response = serializer.deSerializer(data, RpcResponse.class);
                if (Objects.nonNull(response)) {
                    MessageProtocol<RpcResponse> protocol = new MessageProtocol<>();
                    protocol.setHeader(header);
                    protocol.setContent(response);
                    list.add(protocol);
                }
                break;
            default:
                break;
        }
    }
}
