package com.goosuu.code16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itcast", "root", "123456");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT `article_id`,`title`,`desc` FROM sp_articles");
        while(resultSet.next()){
            int article_id = resultSet.getInt(1);
            String title = resultSet.getString("title");
            String desc = resultSet.getString(3);
            System.out.println(article_id+"---"+title+"----"+desc);
        }
        conn.close();
        statement.close();
        resultSet.close();
    }
}
