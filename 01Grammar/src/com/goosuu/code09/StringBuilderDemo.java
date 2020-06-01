package com.goosuu.code09;

/**
 *  StringBuilder:
 *      用途：提升字符串使用效率
 *      构造方法：
 *        StringBuilder()
 *        StringBuilder(String s)：字符串转换为StringBuilder
 *        StringBuilder append(...) 可以接收任何形式参数
 *        toString():StringBuilder转换为字符串
 *
 *
 *
 *
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        //链式编程
        sb.append("s").append(12).append('a');
        System.out.println(sb.toString());
    }
}
