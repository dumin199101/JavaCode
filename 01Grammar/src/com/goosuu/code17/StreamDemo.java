package com.goosuu.code17;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *  Stream流：
 *     获取流方式：
 *       Collection集合转换Stream流：stream()
 *       Stream流：static of(E...args)
 *     延迟方法：
 *      filter(Predicate p)
 *     终结方法：
 *      forEach(Consumer c)
 *
 *
 *
 *
 *
 *
 *
 */
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("张三丰");
        lists.add("张无忌");
        lists.add("赵敏");
        lists.add("周芷若");
        lists.add("张翠山");

        lists.stream()
                .filter(name-> name.length() >= 3)
                .filter(name->name.startsWith("张"))
                .forEach(name-> System.out.println(name));

        System.out.println("****************************");

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        stream1.forEach(v-> System.out.println(v));



    }
}
