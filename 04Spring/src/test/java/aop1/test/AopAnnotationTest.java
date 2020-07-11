package aop1.test;

import aop1.anno.service.AccountService;
import config.SpringAopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAnnotationTest {

    @Test
    public void testAopAnnotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.saveAccount();
    }

}
