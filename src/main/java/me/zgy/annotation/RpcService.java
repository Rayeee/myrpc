package me.zgy.annotation;

import java.lang.annotation.*;

/**
 * Created by Rayee on 2017/10/1.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    Class<?> value();

    String version() default "1.0.0";

}
