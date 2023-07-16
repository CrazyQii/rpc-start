package top.hanlinqi.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import top.hanlinqi.core.codec.RpcDecoder;
import top.hanlinqi.core.codec.RpcEncoder;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @program: NettyServerImpl
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 15:02
 **/
@Slf4j
public class NettyServerImpl implements NettyServer {

    @Override
    public void start(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            String serverAddress = Inet4Address.getLocalHost().getHostAddress();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    // 协议编码
                                    .addLast(new RpcEncoder())
                                    // 协议编码
                                    .addLast(new RpcDecoder())
                                    // 请求处理器
                                    .addLast(new RequestHandler());
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 启动服务
            ChannelFuture channelFuture = bootstrap.bind(serverAddress, port).sync();
            log.info("服务启动成功: {},端口：{}", serverAddress, port);
            // 等待服务通道关闭
            channelFuture.channel().closeFuture().sync();
        } catch (UnknownHostException | InterruptedException e) {
            log.error("netty 服务启动失败!!");
        } finally {
            // 关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
