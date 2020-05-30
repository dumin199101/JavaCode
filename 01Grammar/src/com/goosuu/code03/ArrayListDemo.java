package com.goosuu.code03;

import java.util.ArrayList;

/**
 * ArrayList跟数组区别：
 *   数组长度不能发生改变，ArrayList长度可变
 * ArrayList后边的<E>代表泛型，泛型只能是引用数据类型，代表集合中的元素都是统一的类型
 * 打印ArrayList，得到的不是地址值，而是内容
 * 基本数据类型数据如果想放入集合，那么就得使用包装类（位于java.lang）对基本数据类型进行包装
 * char : Character
 * int : Integer
 * 从JDK1.5开始支持自动装箱（基本数据类型--->包装类型），自动拆箱(包装类型--->基本数据类型)
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //JDK1.7+可以省略右边的泛型
        ArrayList<String> list = new ArrayList();
        //添加
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        //获取
        System.out.println(list.get(1));
        //删除
        System.out.println(list.remove(1));
        //获取集合长度
        System.out.println(list.size());

        System.out.println("================");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        System.out.println(list2);


    }
}
