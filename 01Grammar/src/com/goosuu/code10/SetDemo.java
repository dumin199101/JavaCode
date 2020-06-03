package com.goosuu.code10;

import java.util.HashSet;
import java.util.Set;

/**
 *  Set:
 *    特点：元素不重复，无索引，无序
 *
 *
 *    HashSet:
 *       底层：Hash表（数组+链表+红黑树）,依赖于HashMap
 *       特点：查询速度快
 *       不重复：底层调用hashcode()跟equals()方法
 *
 *    LinkedHashSet:
 *       底层：Hash表（数组+链表+红黑树）+链表（记录元素存储顺序）
 *
 *    TreeSet：
 *       底层：红黑树
 *       自然排序：comparable接口的compareTo方法
 *       比较器排序：comparator接口的compare方法
 *
 *    Object类hashcode():返回一个系统随机的十进制整数值
 *
 *
 *
 *
 *
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(9);
        set.add(7);
        for (Integer i:set) {
            System.out.println(i);
        }
        System.out.println("********************");
        Student<Student> student = new Student<>();
        System.out.println(student.hashCode());
    }
}
