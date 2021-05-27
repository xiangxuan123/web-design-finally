package com.example.springexamples.example03;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class MyAspect2 {
    @Pointcut("execution(* com.example.springexamples.example03..*.*(..))")
    public void pointcut(){};
    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        for (Object arg : joinPoint.getArgs()) {
                    log.debug("arg: "+arg);
        }
        log.debug(joinPoint.getSignature().getName());
        log.debug(joinPoint.getThis().getClass().getName());
    }
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name = (String) args[0];
        if("XX".equals(name)){
            args[0] = "XiangXuan";
        }
        Object object = joinPoint.proceed(args);
        log.debug("连接点方法返回类型：{}",object.getClass());
        return object;
    }
}
