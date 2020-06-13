package com.goosuu.code16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC对象：
 *  DriverManager:
 *     registerDriver(Driver driver)：注册驱动
 *     getConnection()：获取数据库连接
 *  Connection:
 *     createStatement()
 *     preparedStatement(String sql):预编译SQL
 *     事务：
 *       开启事务：setAutoCommit(boolean b)
 *       提交事务：commit()
 *       回滚事务：rollback()
 *  Statement:
 *     executeQuery()
 *     executeUpdate()
 *  PreparedStatement:
 *     sql语句使用？作为占位符：select * from sp_user where id = ?
 *     赋值：
 *       setString​(int parameterIndex, String x)
 *
 *
 *  ResultSet:
 *    boolean next():游标向下移动一行
 *    getXXX():
 *       int getInt(int columnIndex):columnIndex从1开始
 *       String getString(String columnLabel)
 *       Double getDouble(int ColumnIndex)
 *
 *  数据库连接池：
 *     1.c3p0（了解）:
 *        构造方法：ComboPooledDataSource()
 *        成员方法：
 *            getConnection()
 *     2.druid:
 *        成员方法：
 *             DruidDataSourceFactory.createDataSource(Properties properties)
 *             getConnection()
 *   Spring JDBC-Template:
 *      构造方法：
 *         JdbcTemplate(DataSource ds)
 *      成员方法：
 *          update()
 *          queryForMap()：单条记录，封装为Map集合
 *          queryForList()：多条记录，封装为List集合
 *          query(new BeanPropertyRowMapper(Article.class)):封装为JavaBean对象
 *          queryForObject()封装为对象
 *
 *
 *
 *
 *
 *
 */
public class JDBCDemo {
    public static void main(String[] args){
        Connection conn = null;
        Statement statement =null;
        try{
            //1.加载数据库驱动,可省略
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itcast", "root", "123456");
            //3.执行查询
            statement = conn.createStatement();
            //4.SQL语句
            String sql = "UPDATE `sp_articles` SET `title` = 'hello' WHERE `article_id` = 1";
            //5.执行SQL
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.释放数据库连接
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
