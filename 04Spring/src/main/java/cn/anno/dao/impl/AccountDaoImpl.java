package cn.anno.dao.impl;

import cn.anno.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("Save Account According to AccountDaoImpl");
    }
}
