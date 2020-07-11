package aop.test;

import aop.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void testAop(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.saveAccount();
    }
}
