package com.goosuu.code10;
/**
 *   HashSet存储自定义类型元素：
 *      重写hashcode跟equals方法
 *      年龄与姓名相同，认定为同一元素
 *
 *
 *
 */

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Person person1 = new Person("小明",11);
        Person person2 = new Person("小李",22);
        Person person3 = new Person("小明",11);
        Set<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        System.out.println(set);
        System.out.println(person1.hashCode());
        System.out.println(person3.hashCode());
        System.out.println(person1.equals(person3));

    }
}
