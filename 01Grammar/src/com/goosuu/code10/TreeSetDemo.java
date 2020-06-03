package com.goosuu.code10;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Animal> set = new TreeSet<>();
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
