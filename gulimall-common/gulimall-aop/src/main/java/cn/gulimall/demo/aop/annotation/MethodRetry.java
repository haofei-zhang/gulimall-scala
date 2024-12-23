package cn.gulimall.demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Z
 * @since 2024/12/23 下午11:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodRetry {

    int maxRetry() default 3;

    boolean throwException() default false;

}
