package com.goosuu.code10;


import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("123");
        set.add("456");
        set.add("789");
        set.add("123");
        System.out.println(set);
    }
}
