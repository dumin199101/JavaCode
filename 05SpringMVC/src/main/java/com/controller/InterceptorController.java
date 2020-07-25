package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inter")
public class InterceptorController {
    @RequestMapping("/test")
    public String testInterceptor(){
        System.out.println("测试拦截器");
        return "success1";
    }
}
