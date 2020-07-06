package com.itcast.withoutxml.service.impl;

import com.itcast.withoutxml.dao.AccountDao;
import com.itcast.withoutxml.domain.Account;
import com.itcast.withoutxml.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
