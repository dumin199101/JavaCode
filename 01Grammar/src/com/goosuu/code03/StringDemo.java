package com.goosuu.code03;

/**
 *  字符串字面值("ABC")都是String类对象
 *  字符串特点；
 *      字符串内容不可改变，发生变化的是地址值
 *      在内存中可共享使用
 *      字符串效果相当于char[]字符数组,底层相当于byte[]字节数组
 *  字符串创建方式(3+1种)
 *    三种构造方法：
 *    public String()
 *    public String(char[] array)
 *    public String(byte[] array)
 *   字符串字面量创建字符串（只有这种方式的字符串在堆内存字符串常量池中，其余的在堆内存中）
 *   ==比较：
 *     引用数据类型：比较地址值是否相等
 *     基本数据类型：比较值是否相等
 *  字符串方法：
 *   字符串内容比较：equals
 *   字符串拼接：concat
 *   字符串长度：length
 *   字符换第一次出现位置：indexOf(String)
 *   字符串指定位置字符：charAt(Index)
 *   字符串截取：substring(startIndex,endIndex)
 *   字符串转为字符数组：toCharArray()
 *   字符串转为字节数组：getBytes()
 *   字符串替换：replace(CharSequence oldstr,CharSequece newstr)
 *   字符串分割：split()
 *
 *
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = new String();
        System.out.println("字符串："+s);
        char[] ch = new char[]{'h','e','l'};
        String s2 = new String(ch);
        System.out.println("字符串"+s2);
        byte[] byteArray = {97,98,99};
        String s3 = new String(byteArray);
        System.out.println("字符串"+s3);
        String s4 = "Hello";
        System.out.println(s4);
        System.out.println("+++++++++++++++");
        String s5 = "abc";
        String s6 = "abc";
        char[] chars = {'a','b','c'};
        String s7 = new String(chars);
        System.out.println(s5.equals(s6));
        System.out.println(s5.equals(s7));
        System.out.println("+++++++++++++++++++++");
        String s8 = "Hello";
        System.out.println(s8.concat("World"));
        System.out.println(s8.length());
        System.out.println(s8.indexOf("e"));
        System.out.println(s8.charAt(4));
        System.out.println("+++++++++++++++++++");
        System.out.println(s8.substring(0,3));
        char[] chars1 = s8.toCharArray();
        System.out.println(chars1[1]);
        byte[] bytes1 = s8.getBytes();
        System.out.println(bytes1[1]);
        System.out.println(s8.replace("el","wo"));
        String[] ss = "aaa,bbb,ccc".split(",");
        System.out.println(ss[1]);



    }
}
