package com.goosuu.code10;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环
 *
 */
public class ForDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("汤唯");
        //增强for循环
        for (String s : collection) {
            System.out.println(s);
        }
    }
}
