package com.goosuu.code10;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  使用比较器排序：匿名内部类方式
 *
 *
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        Set<Animal> set = new TreeSet(new Comparator<Animal>(){
            @Override
            public int compare(Animal o1, Animal o2) {
                int age = o1.getAge() - o2.getAge();
                return age == 0 ? o1.getName().length() - o2.getName().length() : age;
            }
        });
        Animal dog = new Animal(2, "lisiand1");
        Animal cat = new Animal(3,"wangwu");
        Animal fish = new Animal(2,"zhansan");
        Animal pig = new Animal(5, "abc");
        set.add(dog);
        set.add(cat);
        set.add(fish);
        set.add(pig);
        System.out.println(set);
    }
}
