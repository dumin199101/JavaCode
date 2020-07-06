package com.itcast.withoutxml.dao;

import com.itcast.withoutxml.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
}
