package tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tx.withxml.service.AccountService;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:tx-bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);

    }

}