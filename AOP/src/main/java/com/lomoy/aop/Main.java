package com.lomoy.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
//@EnableLoadTimeWeaving
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true) //todo: 为什么？
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}
