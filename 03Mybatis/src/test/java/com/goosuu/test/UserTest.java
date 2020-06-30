package com.goosuu.test;
/**
 * MyBatis:
 *   持久层框架
 *   主配置文件：
 *      SqlMapConfig.xml:
 *        typeAliases:别名
 *          package：批量别名定义
 *        properties:配置项
 *        mappers:映射器
 *          package：批量注册接口映射
 *    Mybatis控制事务：commit()
 *   基于XML使用Mybatis
 *   基于注解使用Mybatis
 *
 *
 *
 *
 *
 *
 *
 */

import com.goosuu.dao.IUserDao;
import com.goosuu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream is = null;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private IUserDao dao = null;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //构建者模式
        factory = sqlSessionFactoryBuilder.build(is);
        //工厂模式
        sqlSession = factory.openSession();
        //代理模式创建代理对象
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @Test
    public void testFindAllUser(){
        //代理对象调用方法
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testFindByID(){
        User user = dao.findByID(41);
        System.out.println(user);
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("wangwei");
        user.setSex("男");
        user.setBirtyday(new Date());
        user.setAddress("北京市");
        dao.saveUser(user);
        //获取插入id
        Integer uid = user.getId();
        System.out.println(uid);
    }

    @Test
    public void testUpdateUser(){
        User user = dao.findByID(53);
        user.setUsername("lisi");
        user.setBirtyday(new Date());
        user.setSex("男");
        user.setAddress("天津市");
        int i = dao.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteUser(){
        int i = dao.deleteUser(55);
        System.out.println(i);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = dao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int totalUser = dao.findTotalUser();
        System.out.println(totalUser);
    }

    @After
    public void destroy() throws Exception{
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
