package top.hanlinqi.server.annoation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @program: RpcService
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 14:52
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RpcService {

    /**
     * 服务接口类型
     * @return
     */
    Class<?> interfaceType() default Object.class;

    /**
     * 服务版本
     * @return
     */
    String version() default "1.0";
}
