package top.hanlinqi.core.zk.registry;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.x.discovery.ServiceDiscovery;
import top.hanlinqi.core.common.ServiceInfo;

import java.io.IOException;

/**
 * @program: ZookeeperRegistryService
 * @description: zk注册中心注册服务
 * @author: hanLinQi
 * @create: 2023-03-08 12:27
 **/
@Slf4j
public class ZookeeperRegistryServiceImpl implements RegistryService {

    public static final int BASE_SLEEP_TIME_MS = 1000;
    public static final int MAX_RETRIES = 3;
    public static final String ZK_BASE_PATH = "/demo_rpc";

    private ServiceDiscovery<ServiceInfo> serviceDiscovery;


    @Override
    public void register(ServiceInfo serviceInfo) throws Exception {

    }

    @Override
    public void unRegister(ServiceInfo serviceInfo) throws Exception {

    }

    @Override
    public void destroy() throws IOException {

    }
}
