package org.lomoy.aop.ltw;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    public MyAspect() {

    }
    // Pointcut to capture execution of private methods in MyService
    @Before("execution(private * org.lomoy.aop.ltw.MyService.*(..))")
    public void beforePrivateMethod() {
        System.out.println("Intercepted: Before private method execution.");
    }

    @After("execution(private * org.lomoy.aop.ltw.MyService.*(..))")
    public void afterPrivateMethod() {
        System.out.println("Intercepted: After private method execution.");
    }
}
