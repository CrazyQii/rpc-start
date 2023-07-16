package top.hanlinqi.client;

import top.hanlinqi.client.netty.NettyServer;
import top.hanlinqi.client.netty.NettyServerImpl;

/**
 * @program: ClientApplication
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-09 16:28
 **/

public class ClientApplication {

    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServerImpl();
        nettyServer.start(9091);
    }
}
