package com.goosuu.code10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  迭代器遍历集合：
 *    Collection集合继承了Iterable--->Itarator接口，
 *    Collection集合的方法
 *      Iterator iterator():
 *    Iterator接口方法:
 *      hasNext()
 *      next()
 *
 *
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        collection.add("汤唯");
        //迭代器遍历
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
