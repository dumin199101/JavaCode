package com.goosuu.code09;

/**
 *   Object类是所有类的超类
 *      ctrl+alt+v:自动生成变量名
 *      toString():对象的字符串表示，com.goosuu.code09.Person@16b98e56
 *      equals():比较对象是否相等，比较的是地址值
 *
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Person p = new Person(22,"wangwei");
        System.out.println(p);
        System.out.println(p.toString());
        Person p2 = new Person(22,"wangwei");
        boolean equals = p.equals(p2);
        System.out.println(equals);
    }
}
