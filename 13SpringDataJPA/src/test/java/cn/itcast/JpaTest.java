package cn.itcast;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
    /**
     * 立即加载
     */
    @Test
    public void testFind(){
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //获取实体管理对象
            em = JpaUtils.getEntityManager();
            //获取事务对象
            et = em.getTransaction();
            //开启事务
            et.begin();
            //保存
            Customer customer = em.find(Customer.class, 2l);
            //提交事务
            et.commit();
            System.out.println(customer);
        }catch (Exception e){
            //回滚事务
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Test
    public void testAdd(){
        Customer customer = new Customer();
        customer.setCustName("李四");
        customer.setCustAddress("天津");
        customer.setCustIndustry("电力");
        customer.setCustLevel("VIP客户");
        customer.setCustSource("网络");
        customer.setCustPhone("010-84389340");
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //获取实体管理对象
            em = JpaUtils.getEntityManager();
            //获取事务对象
            et = em.getTransaction();
            //开启事务
            et.begin();
            //保存
            em.persist(customer);
            //提交事务
            et.commit();
        }catch (Exception e){
            //回滚事务
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Test
    public void testUpdate(){
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //获取实体管理对象
            em = JpaUtils.getEntityManager();
            //获取事务对象
            et = em.getTransaction();

            Customer customer = em.find(Customer.class, 2l);
            customer.setCustLevel("普通客户");
            customer.setCustSource("信访");
            customer.setCustPhone("021-84389340");

            //开启事务
            et.begin();

            //保存
            em.merge(customer);
            //提交事务
            et.commit();
        }catch (Exception e){
            //回滚事务
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    /**
     * 延迟加载
     */
    @Test
    public void testFind2(){
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //获取实体管理对象
            em = JpaUtils.getEntityManager();
            //获取事务对象
            et = em.getTransaction();
            //开启事务
            et.begin();
            //保存
            Customer customer = em.getReference(Customer.class, 1l);
            //提交事务
            et.commit();
            System.out.println(customer);
        }catch (Exception e){
            //回滚事务
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Test
    public void testDelete(){
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //获取实体管理对象
            em = JpaUtils.getEntityManager();
            //获取事务对象
            et = em.getTransaction();

            Customer customer = em.find(Customer.class, 3l);

            //开启事务
            et.begin();

            //保存
            em.remove(customer);
            //提交事务
            et.commit();
        }catch (Exception e){
            //回滚事务
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }


}
