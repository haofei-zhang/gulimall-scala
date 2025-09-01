package cn.gulimall.demo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author Z
 * @since 2024/12/23 下午11:17
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodKeepOnce {
    /**
     * 加锁时间
     * @return
     */
    int timeout() default 30;

    /**
     * 时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 错误提升信息
     * @return
     */
    String message() default "操作太频繁，请稍后再试";

    /**
     * 锁定key
     * @return
     */
    String lockKey() default "";

    /**
     * 从el表达式中获取加锁关键字
     * @return
     */
    String express() default "";

    /**
     * 完成后是否释放锁
     * @return
     */
    boolean autoRelease() default true;

}
