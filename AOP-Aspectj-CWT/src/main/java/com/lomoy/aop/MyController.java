package com.lomoy.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @Autowired MyService myService;

    @MyLog(myData="VC test")
    @GetMapping("/users")
    public String getUsers(String id){
//        System.out.println("this is code.MyController's getUsers method " + id);
        myService.publicMethodA();
        return id;
    }

}