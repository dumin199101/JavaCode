package com.goosuu.code16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        //1.加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.创建数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itcast", "root", "123456");
        //3.执行查询
        Statement statement = conn.createStatement();
        //4.SQL语句
        String sql = "UPDATE `sp_articles` SET `title` = 'hello' WHERE `article_id` = 1";
        //5.执行SQL
        int i = statement.executeUpdate(sql);
        //6.释放数据库连接
        statement.close();
        conn.close();
        System.out.println(i);
    }
}
