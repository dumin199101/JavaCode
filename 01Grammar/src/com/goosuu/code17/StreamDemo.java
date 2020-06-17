package com.goosuu.code17;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *  Stream流：
 *     获取流方式：
 *       Collection集合转换Stream流：stream()
 *       Stream流：static of(E...args)
 *     Stream流只能被操作一次，如果使用了终结方法就不能再使用了
 *     延迟方法：
 *      filter(Predicate p)
 *      skip()
 *      limit()
 *      static concat(Stream 1,Stream2)
 *      map(Function f):将一个流映射到另一个流,类型转换
 *     终结方法：
 *      forEach(Consumer c)
 *      count()
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
        System.out.println("*****************************");
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream2.count());
        System.out.println("*****************************");
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream3.skip(2).count());
        System.out.println("*****************************");
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5);
        stream4.limit(2).forEach(v-> System.out.println(v));
        System.out.println("*****************************");
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream6 = Stream.of(11, 22, 33, 44, 55);
        Stream<Integer> stream7 = Stream.concat(stream5, stream6);
        stream7.forEach(v-> System.out.println(v));
        System.out.println("*****************************");
        Stream<Integer> stream8 = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = stream8.map((i) -> {
            return String.valueOf(i);
        });

        stringStream.forEach(v-> System.out.println(v instanceof String));
    }
}
