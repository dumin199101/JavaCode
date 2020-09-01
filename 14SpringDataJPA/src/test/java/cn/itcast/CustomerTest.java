package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindOne(){
        Customer customer = customerDao.findOne(1l);
        System.out.println(customer);
    }
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("王五");
        customer.setCustIndustry("纺织");
        customer.setCustAddress("上海");
        customerDao.save(customer);
    }

    @Test
    public void testUpdate(){
        Customer customer = customerDao.findOne(4l);
        customer.setCustPhone("022-84389340");
        customer.setCustLevel("白金客户");
        customerDao.save(customer);
    }
    @Test
    public void testDelete(){
        customerDao.delete(4l);
    }
    @Test
    public void findAll(){
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

}
