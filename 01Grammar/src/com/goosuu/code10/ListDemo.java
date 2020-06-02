package com.goosuu.code10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  List集合：
 *    特点：
 *      1.有序
 *      2.有索引
 *      3.允许重复元素
 *     带索引方法：
 *       add()
 *       remove()
 *       get()
 *       set()
 *
 *
 *
 *
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("麦迪");
        list.add("姚明");
        list.add("科比");
        list.add("科比");
        list.add("邓肯");
        System.out.println(list);
        list.add(3,"霍华德");
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.set(1,"阿泰斯特"));
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        //普通for循环
        for (int i = 0; i < list.size() ; i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("**********************");
        //iterator迭代器
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            System.out.println(s);
        }
        System.out.println("************************");
        //增强for循环
        for (String s : list) {
            System.out.println(s);
        }
    }
}
