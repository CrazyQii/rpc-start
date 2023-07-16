package top.hanlinqi.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: ServiceRequest
 * @description: 服务信息
 * @author: hanLinQi
 * @create: 2023-03-08 12:26
 **/
@Data
public class ServiceInfo implements Serializable {

    /**
     *  应用名称
     */
    private String appName;

    /**
     *  服务名称
     */
    private String serviceName;

    /**
     *  版本
     */
    private String version;

    /**
     *  地址
     */
    private String address;

    /**
     *  端口
     */
    private Integer port;
}
