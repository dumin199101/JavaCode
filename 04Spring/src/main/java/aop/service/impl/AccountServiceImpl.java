package aop.service.impl;

import aop.service.AccountService;

public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("保存账户");
    }

    public void updateAccount(int i) {
        System.out.println("修改账户"+i);
    }

    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }
}
