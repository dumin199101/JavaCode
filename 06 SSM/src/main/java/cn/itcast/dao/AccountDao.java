package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountDao{
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 增加账户
     */
    void saveAccount();

}
