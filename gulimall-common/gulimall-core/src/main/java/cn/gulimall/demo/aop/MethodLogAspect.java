package cn.gulimall.demo.aop;

import cn.gulimall.demo.aop.annotation.MethodLog;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Z
 * @since 2024/12/22 下午11:33
 */
@Aspect
@Slf4j
@Component
public class MethodLogAspect {

    @Around("@annotation(methodLog)")
    public Object around(ProceedingJoinPoint joinPoint, MethodLog methodLog) throws Throwable {

        String methodName = joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();

        List<String> names = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        names.add("method:{}");
        values.add(methodName);

        if (methodLog.logArgs()){
            names.add("args:{}");
            values.add(formatArgs(joinPoint.getArgs()));
        }

        final long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        final long end = System.currentTimeMillis();

        if (methodLog.logReturn()){
            names.add("return:{}");
            values.add(result);
        }
        if (methodLog.logTime()){
            names.add("time:{}");
            values.add(end - start);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name).append(",");
        }
        log.info(stringBuilder.toString(), values.toArray());

        return result;
    }

    private String formatArgs(Object[] args){
        List<Object> list = new ArrayList<>(args.length);
        for (Object obj: args){
            list.add(obj);
        }
        //疑似版本冲突导致类加载失败
        return JSON.toJSONString(list);
    }

}
