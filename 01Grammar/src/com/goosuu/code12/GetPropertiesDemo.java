package com.goosuu.code12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class GetPropertiesDemo {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("D:\\1.txt");
        Properties properties = new Properties();
        properties.load(reader);
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(properties.getProperty(key));
        }
    }
}
