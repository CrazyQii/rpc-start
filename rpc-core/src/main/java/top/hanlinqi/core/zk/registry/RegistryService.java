package top.hanlinqi.core.zk.registry;

import top.hanlinqi.core.common.ServiceInfo;

import java.io.IOException;

/**
 * @program: RegistryService
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 11:31
 **/

public interface RegistryService {

    /**
     * 服务注册
     * @param serviceInfo
     * @throws Exception
     */
    void register(ServiceInfo serviceInfo) throws Exception;

    /**
     * 服务取消注册
     * @param serviceInfo
     * @throws Exception
     */
    void unRegister(ServiceInfo serviceInfo) throws Exception;

    /**
     * 销毁
     * @throws IOException
     */
    void destroy() throws IOException;
}
