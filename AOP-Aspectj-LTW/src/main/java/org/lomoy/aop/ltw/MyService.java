package org.lomoy.aop.ltw;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @MyLog(myData="VC test")
    public void publicMethodA(){
        publicMethodB();
        privateMethodB();
        String staticString =  MyStaticClass.staticGetString();
    }


    @MyLog(myData="VC test")
    public void publicMethodB() {
        publicMethodC();
    }

    @MyLog(myData="VC test")
    public void publicMethodC() {
        return;
    }


    @MyLog(myData="VC test")
    private void privateMethodB() {
    }

}