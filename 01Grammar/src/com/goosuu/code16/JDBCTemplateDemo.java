package com.goosuu.code16;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCTemplateDemo {
    public static void main(String[] args) throws Exception {
        Class<DruidDemo> druidDemoClass = DruidDemo.class;
        ClassLoader classLoader = druidDemoClass.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //查询单条
        String sql = "select * from sp_articles where article_id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stringObjectMap);
        //查询多条
        String sql1 = "select * from sp_articles";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql1);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        //查询数量
        String sql2 = "select count(article_id) from sp_articles";
        Integer count = jdbcTemplate.queryForObject(sql2, int.class);
        System.out.println(count);


    }
}
