package cn.itcast.service.impl;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("查询所有账户");
        return null;
    }

    @Override
    public void saveAccount() {
        System.out.println("增加账户");
    }
}
