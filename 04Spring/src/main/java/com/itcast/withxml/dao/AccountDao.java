package com.itcast.withxml.dao;

import com.itcast.withxml.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
}
