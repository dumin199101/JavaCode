package com.goosuu.service.impl;

import com.goosuu.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {

    private List lists;
    private String[] strs;
    private Set set;
    private Map map;
    private Properties properties;

    public void setLists(List lists) {
        this.lists = lists;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void saveAccount() {
        System.out.println(lists);
        System.out.println(Arrays.toString(strs));
        System.out.println(set);
        System.out.println(map);
        System.out.println(properties);
    }
}
