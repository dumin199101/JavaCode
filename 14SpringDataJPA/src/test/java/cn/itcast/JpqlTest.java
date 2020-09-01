package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }
    @Test
    public void testExist(){
        boolean b = customerDao.exists(2l);
        System.out.println(b);
    }
    @Test
    @Transactional
    public void testGetOne(){
        Customer customer = customerDao.getOne(1l);
        System.out.println(customer);
    }

    @Test
    public void testFindAllCustomer(){
        List<Customer> list = customerDao.findAllCustomer();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
    @Test
    @Transactional
    public void testUpdateCustomer(){
        customerDao.updateCustomer("张飞",1l);
    }

    @Test
    public void testFindSql(){
        List<Object[]> list = customerDao.findSql();
        for (Object[] consumer : list) {
            System.out.println(Arrays.toString(consumer));
        }
    }

    @Test
    public void testFindByCustAddress(){
        List<Customer> customers = customerDao.findByCustAddress("北京");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
