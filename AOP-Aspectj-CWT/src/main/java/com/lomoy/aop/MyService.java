package com.lomoy.aop;

//import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class MyService {


    @MyLog(myData="VC test")
    public void publicMethodA(){
        /**
         *
         * AopContext.currentProxy
         * 可以创建一个方法，然后用This
         *
         */
//        System.out.println(Thread.currentThread().getName() + ": This is methodA");
//        MyService myService = AopContext.currentProxy() !=null ? (MyService)AopContext.currentProxy():this;
//        if (AopContext.currentProxy()==null) {
//            System.out.println("proxy is null");
//        }
        publicMethodB();
//        myService.privateMethodB();
        privateMethodB();
        String staticString =  MyStaticClass.staticGetString();
//        System.out.println("StaticMethod called: " + staticString);
//        this.methodB();
    }


    @MyLog(myData="VC test")
    public void publicMethodB() {
//        System.out.println(Thread.currentThread().getName() + ": This is methodB");
//        MyService myService = AopContext.currentProxy() !=null ? (MyService)AopContext.currentProxy():this;
        publicMethodC();
    }

    @MyLog(myData="VC test")
    public void publicMethodC() {
        return;
    }


    @MyLog(myData="VC test")
    private void privateMethodB() {
//        System.out.println(Thread.currentThread().getName() + ": This is privateMethodB");
    }

}
