package com.goosuu.code12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *  Properties:
 *     父类：Hashtable
 *     双列集合，key跟value都是字符串
 *     作用：集合跟IO流相结合
 *     方法：
 *          store(Writer writer,String comments):集合到硬盘,comments为描述信息，可为空字符串
 *          store(OutputStream out,String comments):集合到硬盘
 *          load(InputStream in):硬盘到集合
 *          load(Reader reader):硬盘到集合
 *          SetProperty(key,value):相当于map中的put
 *          getProperty(key,value):相当于map中的get
 *          stringPropertyNames():相当于map中的keyset
 *
 *
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("杨过", "小龙女");
        properties.setProperty("郭靖", "黄蓉");
        properties.setProperty("杨康", "穆念慈");

        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(properties.getProperty(key));
        }

        FileWriter fw = new FileWriter("D:\\1.txt");
        properties.store(fw,"save data");
        fw.close();


    }
}
