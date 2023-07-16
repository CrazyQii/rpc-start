package top.hanlinqi.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: ServerConfig
 * @description: 服务端读取配置文件
 * @author: hanLinQi
 * @create: 2023-03-08 14:40
 **/
@Data
@ConfigurationProperties(prefix = "rpc.server")
public class ServerProperties {

    /**
     *  服务启动端口
     */
    private Integer port = 8090;

    /**
     *  服务名称
     */
    private String appName;

    /**
     *  注册中心地址
     */
    private String registryAddr = "127.0.0.1:2181";
}
