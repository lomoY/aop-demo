package org.lomoy.aop.ltw;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyLogAspect {
    /**
     * Aspectj requires a default contractor. You can try to remove it, and you will see error
     */
    public MyLogAspect(){

    }

    @Before("execution(* org.lomoy..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }
}
