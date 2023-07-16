package top.hanlinqi.server.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import top.hanlinqi.core.common.RpcRequest;
import top.hanlinqi.core.common.RpcResponse;
import top.hanlinqi.core.enums.RequestType;
import top.hanlinqi.core.protocol.Header;
import top.hanlinqi.core.protocol.MessageProtocol;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @program: RequestHandler
 * @description: 服务端请求处理器
 * @author: hanLinQi
 * @create: 2023-03-08 15:14
 **/
@Slf4j
public class RequestHandler extends SimpleChannelInboundHandler<MessageProtocol<RpcRequest>> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol<RpcRequest> rpcRequestMessageProtocol) throws Exception {
        MessageProtocol<RpcResponse> messageProtocol = new MessageProtocol<>();
        RpcResponse response = new RpcResponse();
        Header header = new Header();
        // 设置响应类型
        header.setReqType(RequestType.RESPONSE.getCode());
        // 服务端处理请求
        Object result = handle(rpcRequestMessageProtocol.getContent());
        // 将处理完成的请求返回给客户端
        response.setData(result);
        messageProtocol.setHeader(header);
        messageProtocol.setContent(response);
        // 把数据写回去
        channelHandlerContext.writeAndFlush(messageProtocol);
    }

    /**
     * 通过反射获取数据
     * @param request 请求
     * @return
     */
    public Object handle(RpcRequest request) {
        try {
            Object o = request.getClassName();
            if (Objects.isNull(o)) {
                throw new RuntimeException("服务不存在" + request.getClassName());
            }
            Method method = o.getClass().getMethod(request.getMethodName(), request.getParamTypes());
            return method.invoke(o, request.getParams());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
