package com.goosuu.code10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合框架：
 *    Collection
 *       List接口:
 *           包含：ArrayList,Vector,LinkedList
 *           特点：元素可重复，存取有序
 *       Set接口:
 *           包含：TreeSet,HashSet（->LinkedHashSet有序）
 *           特点：元素不可重复，存取无序
 *       方法：
 *          add()
 *          remove()
 *          clear()
 *          size()
 *          contains()
 *          isEmpty()
 *          toArray()
 *
 *
 *
 *
 *
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("张柳");
        System.out.println(collection);
        System.out.println(collection.remove("张柳"));
        System.out.println(collection);
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println(collection.contains("王五"));
        Object[] list = collection.toArray();
        System.out.println(Arrays.toString(list));


    }

}
