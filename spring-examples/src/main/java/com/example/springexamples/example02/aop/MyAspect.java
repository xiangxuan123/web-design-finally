package com.example.springexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Pointcut("execution(* com.example.springexamples.example02.aop..*.buy*(..))")
    public void  pointcut(){}
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object object = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug("{}",end-start);
    }

    @Around(value = "@within(myInterceptor)||@annotation(myInterceptor)")
    public Object interceptorTarget(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        if(myInterceptor == null){
            myInterceptor = joinPoint.getTarget().getClass().getAnnotation(MyInterceptor.class);
        }
        for(MyInterceptor.MyAuthorityType t:myInterceptor.value()){
            log.debug(String.valueOf(t));
        }
        return joinPoint.proceed();
    }
    /*@Pointcut("execution(* com.example.springexamples.example02.aop..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeAdvice() {
        log.debug("beforeAdvice()");
    }
    @After("pointcut()")
    public void afterAdvice() {
        log.debug("afterAdvice()");
    }*/
}
