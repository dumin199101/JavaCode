package com.goosuu.code16;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Class<DruidDemo> druidDemoClass = DruidDemo.class;
        ClassLoader classLoader = druidDemoClass.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
