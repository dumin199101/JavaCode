package cn.anno.ui;

import cn.anno.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("anno.xml");
        AccountService service = context.getBean("accountServiceImpl", AccountService.class);
        service.saveAccount();
        context.close();
    }
}
