package top.hanlinqi.client.annoation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 *
 * @author HanLq
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RpcReference {

    String version() default "1.0";
}
