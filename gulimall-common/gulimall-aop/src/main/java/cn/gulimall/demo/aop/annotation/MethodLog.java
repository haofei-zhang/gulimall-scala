package cn.gulimall.demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Z
 * @since 2024/12/22 下午6:57
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLog {

    boolean logArgs() default true;

    boolean logReturn() default true;

    boolean logTime() default true;
}
