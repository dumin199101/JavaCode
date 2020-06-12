package com.goosuu.code16;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        for (int i=0;i<3;i++){
            Connection conn = comboPooledDataSource.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
