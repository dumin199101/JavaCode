package com.goosuu.code17;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  函数式接口：
 *     定义：接口中有且只有一个抽象方法
 *     好处：延迟加载，性能提升
 *     注解：@FunctionalInterface
 *     典型实现：Lambda表达式
 *     包：java.util.functions
 *
 *     生产型接口：
 *        Supplier:根据接口泛型类型生成对应类型数据
 *        get()
 *     消费型接口：
 *        Consumer:根据接口泛型类型消费对应类型数据
 *        抽象方法：
 *          accept()
 *        默认方法:
 *          andThen():连接消费接口
 *     Predicate接口：
 *        作用：对传入数据类型数据进行判断
 *        抽象方法：
 *           boolean test()
 *        默认方法：
 *          and()：并且
 *          or()：或
 *          negate():取反
 *
 *     Function接口：
 *        作用：对传入数据类型数据进行转换
 *        抽象方法：
 *          apply()
 *        默认方法：
 *          addThen()
 *
 *
 *
 *
 *
 */
public class FunctionInterfaceDemo {
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void consume(String name, Consumer con){
        con.accept(name);
    }

    public static void consume2(String name,Consumer<String> con1,Consumer<String> con2){
        con1.andThen(con2).accept(name);
    }

    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static boolean checkString(String s, Predicate<String> pre1,Predicate<String> pre2){
        return pre1.and(pre2).test(s);
    }

    public static boolean checkString2(String s, Predicate<String> pre1,Predicate<String> pre2){
        return pre1.or(pre2).test(s);
    }

    public static boolean checkString3(String s, Predicate<String> pre1){
        return pre1.negate().test(s);
    }

    public static int changeStringToInt(String s, Function<String,Integer> func){
        return func.apply(s);
    }

    public static String change(String s,Function<String,Integer> func1,Function<Integer,String> func2){
        return func1.andThen(func2).apply(s);
    }

    public static void main(String[] args) {
        String s = getString(()->"Hello");
        System.out.println(s);
        System.out.println("***********************");
        consume("World", (Object name) ->{
            System.out.println(name);
            String newname = new StringBuffer(String.valueOf(name)).reverse().toString();
            System.out.println(newname);
        });
        System.out.println("*********************");
        consume2("Good",(name)->{
            System.out.println(name.toLowerCase());
        },(name)->{
            System.out.println(name.toUpperCase());
        });
        System.out.println("**********************");
        boolean b = checkString("Good",str -> str.length() > 5);
        System.out.println(b);
        System.out.println("**********************");
        boolean b2 = checkString("Good",str -> str.length() > 3,str->str.contains("o"));
        System.out.println(b2);
        boolean b3 = checkString2("Good",str -> str.length() > 6,str->str.contains("o"));
        System.out.println(b3);
        boolean b4 = checkString3("Good",str->str.length()>6);
        System.out.println(b4);
        System.out.println("************************");
        int number = changeStringToInt("1234",num->Integer.parseInt(num));
        System.out.println(number);
        System.out.println("**************************");
        String result = change("10",num->{
            int i = Integer.parseInt(num);
            return i;
        },(Integer i)->{
           String str = String.valueOf(i) + "Hello";
           return str;
        });
        System.out.println(result);

    }

}
