package cn.itcast;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {
    @Test
    public void findAll(){
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
            Query query = em.createQuery("from Customer");
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
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
    public void findCount(){
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
            Query query = em.createQuery("select count(custId) from Customer");
            Object singleResult = query.getSingleResult();
            System.out.println(singleResult);
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
    public void testCondition(){
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
            Query query = em.createQuery("from Customer where custName like ?");
            query.setParameter(1,"%张%");
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
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
    public void testPage(){
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
            Query query = em.createQuery("from Customer");
            query.setFirstResult(1);
            query.setMaxResults(1);
            List resultList = query.getResultList();
            for (Object o : resultList) {
                System.out.println(o);
            }
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
