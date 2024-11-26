package com.lomoy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAspect {

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public MyLogAspect(@Qualifier("aspectThreadPool") ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    /*
    在任何方法执行前就会开跑
     */
//    @Before("@annotation(MyLog)")
//    public void beforeAdvice(JoinPoint joinPoint){
//
//        String signatrureName = joinPoint.getSignature().getName();
//        System.out.println(Thread.currentThread().getName() + ": beforeAdvice: " + signatrureName);
//        System.out.println("this is before ");
//    }

    @Pointcut("execution(private * *(..))")
    public void anyPrivateMethod() {}

    @Before("@annotation(MyLog)")
    public void beforeAdviceWithThread(JoinPoint joinPoint){
        threadPoolTaskExecutor.execute(() -> {
            String signatrureName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            System.out.println(Thread.currentThread().getName() + ": beforeAdvice[ " + "method name: " + signatrureName);
        });
    }

    @After("@annotation(MyLog)")
    public void afterAdviceWithThread(JoinPoint joinPoint){
        threadPoolTaskExecutor.execute(() -> {
            String signatrureName = joinPoint.getSignature().getName();
            System.out.println(Thread.currentThread().getName() + ": afterAdvice: " + signatrureName);
        });
    }
}
