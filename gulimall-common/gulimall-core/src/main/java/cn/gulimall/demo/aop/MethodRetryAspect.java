package cn.gulimall.demo.aop;

import cn.gulimall.demo.aop.annotation.MethodRetry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Z
 * @since 2024/12/23 下午11:14
 */
@Slf4j
@Component
@Aspect
@Order(0)
public class MethodRetryAspect {

    @Around("@annotation(mr)")
    public Object around(ProceedingJoinPoint joinPoint, MethodRetry mr) throws Throwable {
        int count = 0;
        Exception exception = null;
        do{
            try {
                return joinPoint.proceed();
            } catch (Exception e) {
                exception = e;
            }
        }while (++count <= mr.maxRetry());
        throw new RuntimeException("try max", exception);
    }

}
