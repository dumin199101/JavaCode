package com.goosuu.test;

import com.goosuu.dao.IUserDao;
import com.goosuu.domain.Account;
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
            List<Account> accounts = user.getAccounts();
            System.out.println(accounts);
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
        user.setUserName("longwen");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        user.setUserAddress("长沙市");
        dao.saveUser(user);
        //获取插入id
        Integer uid = user.getUserId();
        System.out.println(uid);
    }

    @Test
    public void testUpdateUser(){
        User user = dao.findByID(54);
        user.setUserName("chenwei");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUserAddress("上海市");
        int i = dao.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteUser(){
        int i = dao.deleteUser(52);
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
