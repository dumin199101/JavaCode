package cn.anno.service.impl;

import cn.anno.dao.AccountDao;
import cn.anno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao2")
    private AccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

    public void saveAccount() {
//        System.out.println("Save Account According to Annotation");
        accountDao.saveAccount();
    }
}
