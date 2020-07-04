package com.goosuu.service.impl;

import com.goosuu.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    private String name;
    private Date birthday;
    private int age;

    public AccountServiceImpl(String name, Date birthday, int age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public void saveAccount() {
        System.out.println("Account["+this.name+","+this.age+","+this.birthday+"]");
    }
}
