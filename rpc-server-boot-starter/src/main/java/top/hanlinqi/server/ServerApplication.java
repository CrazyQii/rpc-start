package top.hanlinqi.server;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.hanlinqi.server.netty.NettyServer;

import javax.annotation.Resource;

/**
 * @program: ServerApplication
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 15:50
 **/
@SpringBootApplication
@ComponentScan({"top.hanlinqi.server.config"})
public class ServerApplication implements ApplicationRunner {

    @Resource
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nettyServer.start(9999);
    }

}
