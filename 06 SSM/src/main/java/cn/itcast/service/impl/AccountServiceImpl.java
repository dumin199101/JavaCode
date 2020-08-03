package cn.itcast.service.impl;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户");
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("增加账户");
    }
}
