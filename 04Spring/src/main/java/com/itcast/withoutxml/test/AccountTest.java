package com.itcast.withoutxml.test;

import com.itcast.withoutxml.domain.Account;
import com.itcast.withoutxml.service.AccountService;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void testFindAll(){
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);*/
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
