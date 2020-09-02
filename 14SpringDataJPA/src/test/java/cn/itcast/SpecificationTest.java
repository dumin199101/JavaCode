package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpecificationTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 精确查询
     */
    @Test
    public void testFindOne(){
        Customer one = customerDao.findOne(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Predicate predicate = cb.equal(custName, "张飞");
                return predicate;
            }
        });
        System.out.println(one);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testSpecification1(){
        List<Customer> all = customerDao.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Predicate predicate = cb.like(root.get("custLevel"), "普通%");
                Predicate predicate = cb.like(root.get("custLevel").as(String.class), "普通%");
                return predicate;
            }
        });
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    /**
     * 联合条件查询
     */
    @Test
    public void testSpecification2(){
        Customer one = customerDao.findOne(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custLevel = root.get("custLevel");
                Path<Object> custAddress = root.get("custAddress");
                Predicate predicate1 = cb.equal(custLevel, "普通客户");
                Predicate predicate2 = cb.equal(custAddress, "北京");
                Predicate predicate = cb.and(predicate1, predicate2);
                return predicate;
            }
        });
        System.out.println(one);
    }

    /**
     * 排序
     */
    @Test
    public void testSpecification3(){
        List<Customer> customers = customerDao.findAll(new Sort(Sort.Direction.DESC, "custId"));
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 分页
     */
    @Test
    public void testSpecification4(){
        Pageable page = new PageRequest(0,2);
        Page<Customer> customers = customerDao.findAll(page);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
