package top.hanlinqi.server.netty;

/**
 * @program: RpcServer
 * @author: hanLinQi
 * @create: 2023-03-08 15:01
 **/
public interface NettyServer {

    /**
     * 启动服务
     * @param port 端口
     */
    void start(int port);
}
