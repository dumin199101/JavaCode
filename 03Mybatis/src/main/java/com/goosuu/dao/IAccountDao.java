package com.goosuu.dao;

import com.goosuu.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据uid查询账户信息
     * @param id
     * @return
     */
    List<Account> findByID(Integer id);
}
