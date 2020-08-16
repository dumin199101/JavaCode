package com.itcast.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itcast.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name){
        System.out.println("Hello");
        return helloService.sayHello(name);
    }
}
