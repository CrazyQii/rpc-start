package top.hanlinqi.client.proxy;

import lombok.extern.slf4j.Slf4j;
import top.hanlinqi.core.common.RpcRequest;
import top.hanlinqi.core.enums.ProtocolConstants;
import top.hanlinqi.core.enums.SerializerType;
import top.hanlinqi.core.protocol.Header;
import top.hanlinqi.core.protocol.MessageProtocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: ClientProxy
 * @description: 客户端代理
 * @author: hanLinQi
 * @create: 2023-03-08 17:30
 **/
@Slf4j
public class ClientProxy implements InvocationHandler {

    public <T> T clientProxy(Class<T> interfaceCls, String host, int port) {
//        Prox
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("调用 invoke 方法");
        // 组装参数
        MessageProtocol<RpcRequest> protocol = new MessageProtocol<>();
        Header header = new Header();
        header.setMagic(ProtocolConstants.MAGIC);
        header.setSerialType(SerializerType.JAVA_SERIAL.code());
        protocol.setHeader(header);
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamTypes(method.getParameterTypes());
        request.setParams(args);
        protocol.setContent(request);
        // 设置请求
        

        return null;
    }
}
