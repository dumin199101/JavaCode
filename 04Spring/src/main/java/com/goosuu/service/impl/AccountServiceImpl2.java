package com.goosuu.service.impl;

import com.goosuu.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {
    private String username;
    private Date birthday;
    private int age;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void saveAccount() {
        System.out.println("Account["+this.username+","+this.age+","+this.birthday+"]");
    }
}
