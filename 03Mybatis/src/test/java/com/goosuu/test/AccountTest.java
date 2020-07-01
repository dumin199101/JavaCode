package com.goosuu.test;

import com.goosuu.dao.IAccountDao;
import com.goosuu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream is = null;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private IAccountDao dao = null;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //构建者模式
        factory = sqlSessionFactoryBuilder.build(is);
        //工厂模式
        sqlSession = factory.openSession();
        //代理模式创建代理对象
        dao = sqlSession.getMapper(IAccountDao.class);
    }

    @Test
    public void testOneToOne(){
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @After
    public void destroy() throws Exception{
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
