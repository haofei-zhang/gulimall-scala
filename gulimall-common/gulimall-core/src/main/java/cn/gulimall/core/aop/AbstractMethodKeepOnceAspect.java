package cn.gulimall.core.aop;

import cn.gulimall.core.aop.annotation.MethodKeepOnce;
import cn.hutool.core.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;

/**
 * 需要实现具体锁的方式
 * @author Z
 * @since 2024/12/23 下午11:21
 */
@Aspect
@Slf4j
abstract public class AbstractMethodKeepOnceAspect {

    private final SpelExpressionParser parser = new SpelExpressionParser();

    abstract public Lock getLock(String lockKey);

    @Around("@annotation(methodKeepOnce)")
    public Object around(ProceedingJoinPoint joinPoint, MethodKeepOnce methodKeepOnce) throws Throwable {
        final Lock lock = getLock(methodKeepOnce.lockKey() + ":" + expressKey(joinPoint, methodKeepOnce));
        boolean success = lock.tryLock(methodKeepOnce.timeout(), methodKeepOnce.timeUnit());
        if (!success){
            throw new RuntimeException(methodKeepOnce.message());
        }
        try {
            return joinPoint.proceed();
        }finally {
            if (methodKeepOnce.autoRelease()){
                lock.unlock();
            }
        }
    }

    private String expressKey(ProceedingJoinPoint joinPoint, MethodKeepOnce methodKeepOnce){
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Method method = signature.getMethod();
        DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        final String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        final Object[] args = joinPoint.getArgs();
        if (ArrayUtil.isEmpty(args) || ArrayUtil.isEmpty(parameterNames) || args.length != parameterNames.length){
            throw new RuntimeException("方法参数与参数数量不符");
        }

        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < args.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }
        return parser.parseExpression(methodKeepOnce.express()).getValue(context, String.class);
    }

}
