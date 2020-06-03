package com.goosuu.code10;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *   Collections工具类：
 *       addAll(Collection<? super T> c, T... elements)
 *       shuffle()
 *       sort():
 *         1.自然排序：被排序的集合存储的元素必须实现Comparable接口的compareTo方法
 *         2.比较器排序，实现Comparator接口，重写compare方法
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
