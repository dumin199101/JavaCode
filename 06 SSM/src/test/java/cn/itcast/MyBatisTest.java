package cn.itcast;


import cn.itcast.repository.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findAlltest() throws IOException {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> lists = dao.findAll();
        for (Account list : lists) {
            System.out.println(list.getName()+"---"+list.getMoney());
        }
        //释放资源
        session.close();
        is.close();
    }

    @Test
    public void saveAccounttest() throws IOException {
        Account account = new Account();
        account.setMoney(1000.00);
        account.setName("ddd");
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);

        //提交事务
        session.commit();

        //释放资源
        session.close();
        is.close();
    }
}
