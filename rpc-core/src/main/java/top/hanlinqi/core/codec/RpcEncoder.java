package top.hanlinqi.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;
import top.hanlinqi.core.protocol.Header;
import top.hanlinqi.core.protocol.MessageProtocol;
import top.hanlinqi.core.serializer.ISerializer;
import top.hanlinqi.core.serializer.SerializerManager;

/**
 * @program: RpcEncode
 * @description: 加码
 * @author: hanLinQi
 * @create: 2023-03-07 17:20
 **/
@Slf4j
public class RpcEncoder<T> extends MessageToByteEncoder<MessageProtocol<T>> {

    /**
     *
     * +----------------------------------------------+
     * | 魔数 2byte | 序列化算法 1byte | 请求类型 1byte  |
     * +----------------------------------------------+
     * | 消息 ID 32byte     |      数据长度 4byte       |
     * +----------------------------------------------+
     *
     * @param channelHandlerContext
     * @param tMessageProtocol
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol<T> tMessageProtocol, ByteBuf byteBuf) throws Exception {
        Header header = tMessageProtocol.getHeader();
        // 魔数
        byteBuf.writeShort(header.getMagic());
        // 序列化
        byteBuf.writeByte(header.getSerialType());
        // 请求类型
        byteBuf.writeByte(header.getReqType());
        // 消息
        byteBuf.writeLong(header.getRequestId());
        // 数据长度
        byteBuf.writeInt(header.getLength());

        // 序列化
        ISerializer serializer = SerializerManager.getSerializer(header.getSerialType());
        byte[] data = serializer.serializer(tMessageProtocol.getContent());

        // 数据内容
        byteBuf.writeBytes(data);

    }
}
