package cn.itcast;

import cn.itcast.dao.Customer1Dao;
import cn.itcast.dao.LinkmanDao;
import cn.itcast.domain.Customer1;
import cn.itcast.domain.Linkeman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private Customer1Dao customer1Dao;
    @Autowired
    private LinkmanDao linkmanDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd(){
        Customer1 customer1 = new Customer1();
        customer1.setCustName("百度");

        Linkeman linkeman = new Linkeman();
        linkeman.setLkmName("王媛媛");

        //建立双向关联
        customer1.getLinkmans().add(linkeman);
        linkeman.setCustomer1(customer1);

        customer1Dao.save(customer1);
        linkmanDao.save(linkeman);


    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd(){
        Customer1 customer1 = new Customer1();
        customer1.setCustName("百度123");

        Linkeman linkeman = new Linkeman();
        linkeman.setLkmName("王媛媛123");

        //建立双向关联
        customer1.getLinkmans().add(linkeman);
        linkeman.setCustomer1(customer1);

        customer1Dao.save(customer1);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeDel(){
        customer1Dao.delete(100l);
    }
}
