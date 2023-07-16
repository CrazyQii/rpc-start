package top.hanlinqi.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.hanlinqi.server.netty.NettyServer;
import top.hanlinqi.server.netty.NettyServerImpl;

import javax.annotation.Resource;

/**
 * @program: RpcServerAutoConfiguration
 * @description: 服务信息自动配置
 * @author: hanLinQi
 * @create: 2023-03-08 14:50
 **/
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(ServerProperties.class)
public class RpcServerAutoConfiguration {

    @Resource
    private ServerProperties properties;

    @Bean
    NettyServer nettyServer() {
        return new NettyServerImpl();
    }
}
