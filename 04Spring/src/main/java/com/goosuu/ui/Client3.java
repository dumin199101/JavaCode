package com.goosuu.ui;

import com.goosuu.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = context.getBean("AccountServiceImpl3", AccountService.class);
        accountService.saveAccount();
    }
}
