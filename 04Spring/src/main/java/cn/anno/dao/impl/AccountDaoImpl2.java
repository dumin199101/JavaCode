package cn.anno.dao.impl;

import cn.anno.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("Save Account According to AccountDaoImpl2");
    }
}
