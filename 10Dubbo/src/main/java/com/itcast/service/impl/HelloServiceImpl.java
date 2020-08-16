package com.itcast.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itcast.service.HelloService;
//发布为服务，使用dubbo提供的注解
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
