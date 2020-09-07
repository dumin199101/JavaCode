package cn.itcast;

import cn.itcast.dao.Customer1Dao;
import cn.itcast.dao.LinkmanDao;
import cn.itcast.domain.Customer1;
import cn.itcast.domain.Linkeman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 *  对象导航查询：
 *     一对多：延迟加载
 *     多对一：立即加载
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ObjectNavQueryTest {

    @Autowired
    private Customer1Dao customer1Dao;
    @Autowired
    private LinkmanDao linkmanDao;

    //测试一对多
    @Test
    //解决no session问题
    @Transactional
    public void testOneToManyQuery(){
        Customer1 customer1 = customer1Dao.findOne(97l);
        Set<Linkeman> linkmans = customer1.getLinkmans();
        for (Linkeman linkman : linkmans) {
            System.out.println(linkman);
        }
    }

    //测试多对一
    @Test
    @Transactional
    public void testManyToOneQuery(){
        Linkeman linkeman = linkmanDao.findOne(5l);
        Customer1 customer1 = linkeman.getCustomer1();
        System.out.println(customer1);
    }


}
