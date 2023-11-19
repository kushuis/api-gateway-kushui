package com.kushui.gateway.core.datasource.connection;

import com.kushui.gateway.core.datasource.Connection;
import com.kushui.rpc.client.generic.GenericService;
import com.kushui.rpc.client.generic.GenericServiceFactory;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;


/**
 * @description RPC Dubbo Connection
 */
public class DubboConnection implements Connection {

    private final GenericService genericService;

    public DubboConnection(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ReferenceConfig<GenericService> reference) {
        // 连接远程服务
//        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
//        bootstrap.application(applicationConfig).registry(registryConfig).reference(reference).start();
//        // 获取泛化接口
//        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
//        genericService = cache.get(reference);

         genericService = GenericServiceFactory.getInstance(reference.getInterface());
//        Object result = instance.$invoke("sayHi", new String[]{"java.lang.String"}, new Object[]{"yasina"});
//        System.out.println("===========================");
//        System.out.println(result.toString());

    }

    /**
     * Dubbo 泛化调用：https://dubbo.apache.org/zh/docsv2.7/user/examples/generic-reference/
     */
    @Override
    public Object execute(String method, String[] parameterTypes, String[] parameterNames, Object[] args) {
        return genericService.$invoke(method, parameterTypes, args);
    }

}
