package top.hanlinqi.core.zk.discovery;

import top.hanlinqi.core.common.ServiceInfo;

/**
 * @program: DiscoveryService
 * @author: hanLinQi
 * @create: 2023-03-08 14:01
 **/
public interface DiscoveryService {

    /**
     *  发现
     * @param serviceName
     * @return
     * @throws Exception
     */
    ServiceInfo discovery(String serviceName) throws Exception;
}
