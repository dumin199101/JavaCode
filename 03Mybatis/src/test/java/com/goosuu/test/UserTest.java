package com.goosuu.test;
/**
 * MyBatis:
 *   持久层框架
 *   Mybatis连接池：POOLED,UNPOOLED,JNDI
 *   Mybatis事务控制：
 *     自动提交：openSession(true)
 *     手动提交：commit()
 *   Mybatis多表查询：
 *     pojo对象+resultMap
 *     一对一：association
 *     一对多：collection
 *     多对多：collection(双向一对多)
 *   延迟加载：
 *      也称懒加载，需要用到数据时才进行加载，不需要用到数据时就不加载数据。
 *      使用association与collection可实现懒加载
 *        属性：
 *          select:指定查询关联表SQL
 *          culumn:SQL语句的参数字段
 *      开启延迟加载开关：lazyLoadingEnabled
 *   缓存：
 *    一级缓存
 *       SqlSession级别缓存,只要SqlSession未关闭或者flush，缓存就存在。缓存的是对象
 *    二级缓存
 *       SqlSessionFactory级别缓存，缓存的是数据,同一个SqlSessionFactory创建的SqlSession对象共享数据
 *       注意：
 *         1.实体类必须实现Serializable接口
 *         2.IUserDao.xml跟select标签开启二级缓存
 *   主配置文件：
 *      SqlMapConfig.xml:
 *        typeAliases:别名
 *          typeAlias:
 *             属性：
 *               alias
 *               type
 *          package：批量别名定义
 *        properties:配置项
 *        mappers:映射器
 *          属性：
 *            resource:xml方式
 *            class:注解方式
 *          package：批量注册接口映射
 *
 *    动态SQL:
 *      <if></if>
 *      <where></where>
 *      <foreach></foreach>
 *      <sql></sql>
 *      <include></include>
 *   基于XML使用Mybatis
 *      <mapper></mapper>
 *        属性：namespace
 *      CRUD操作：
 *        <select></select>
 *        <insert></insert>
 *        <update></update>
 *        <delete></delete>
 *        属性：
 *          id
 *          resultType
 *          parameterType:可传递pojo类查询对象
 *          resultMap:实体类属性与查询列不一致时使用
 *   基于注解使用Mybatis
 *       @Insert:实现新增
 *       @Update:实现更新
 *       @Delete:实现删除
 *       @Select:实现查询
 *       @Result:实现结果集封装
 *       @Results:可以与@Result一起使用，封装多个结果集
 *       @ResultMap:实现引用@Results定义的封装
 *       @One:实现一对一结果集封装
 *       @Many:实现一对多结果集封装
 *       @CacheNamespace:实现注解二级缓存的使用
 *
 *
 *
 *
 *
 *
 *
 */

import com.goosuu.dao.IUserDao;
import com.goosuu.domain.QueryVo;
import com.goosuu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
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
            System.out.println(user.getAccount());
        }

    }

    @Test
    public void testLazyLoad(){
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccount());
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
        user.setBirthday(new Date());
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
        user.setBirthday(new Date());
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

    @Test
    public void testFindByQueryVo(){
        User user = new User();
        user.setUsername("wangwei");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(51);
        list.add(52);
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        queryVo.setIds(list);
        List<User> users = dao.findByQueryVo(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFirstCache(){
        User user1 = dao.findByID(50);
        System.out.println(user1);
        sqlSession.clearCache();
        User user2 = dao.findByID(50);
        System.out.println(user2);
        System.out.println(user1==user2);
    }

    @Test
    public void testSecondCache(){
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findByID(50);
        System.out.println(user1);
        //关闭一级缓存
        sqlSession1.close();
        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findByID(50);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println(user1==user2);
    }

    @After
    public void destroy() throws Exception{
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
