package com.itcast.withxml.service.impl;

import com.itcast.withxml.dao.AccountDao;
import com.itcast.withxml.domain.Account;
import com.itcast.withxml.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
