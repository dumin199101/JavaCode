package com.itcast.withxml.test;

import com.itcast.withxml.domain.Account;
import com.itcast.withxml.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    @Test
    public void testFindAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("account.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
