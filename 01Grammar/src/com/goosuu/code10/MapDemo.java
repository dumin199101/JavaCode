package com.goosuu.code10;

import java.util.*;

/**
 *  Map:
 *    特点：双列集合，Key不允许重复，Value可以重复，查询速度快
 *
 *  Hashtable：底层：Hash表，同步，线程安全，单线程，速度慢，不允许null键值对
 *
 *  HashMap：底层：Hash表，非同步，线程不安全，多线程，速度快，无序集合，允许null键值对
 *     put(key,value):覆盖写，返回的是指定键上次的值，没有返回null
 *     get(key)
 *     remove(key)
 *     containsKey()
 *     containsValue()
 *     Set keySet()
 *     Set<Map.Entry<K,V>entrySet()
 *        Map.Entry对象：
 *           getKey()
 *           getValue()
 *     values()
 *
 *     LinkedHashMap:底层:Hash表+链表，有序集合，拥有可预知的迭代顺序
 *
 *  TreeMap:非同步，线程不安全。
 *
 *  增强for快捷键：变量名.for
 *
 *  JDK9新特性：List接口，Map接口，Set接口添加静态方法of添加元素
 *      注意：
 *        1.Set接口跟Map接口不允许有重复值
 *        2.集合一旦创建不能修改集合长度，即不能删除、添加
 *
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("李晨", "范冰冰");
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        System.out.println(map);
        System.out.println(map.containsKey("李晨"));
        System.out.println(map.containsValue("小龙女"));
        System.out.println(map.get("郭靖"));
        Collection<String> values = map.values();
        System.out.println(values);
        Set<String> keys = map.keySet();
        System.out.println(keys);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String,String> entry : entries){
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
        System.out.println("---------------------------------------");
        LinkedHashMap<String, Integer> lhashmap = new LinkedHashMap<>();
        lhashmap.put("a", 12);
        lhashmap.put("c", 22);
        lhashmap.put("b", 21);
        Set<String> keyset = lhashmap.keySet();
        for (String s : keyset) {
            System.out.println(lhashmap.get(s));
        }
        System.out.println("-----------------------------------------");
        Set set1 = Set.of("a", "b", "c", "d");
        System.out.println(set1);

    }
}
