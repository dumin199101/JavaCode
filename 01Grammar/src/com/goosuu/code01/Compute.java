package com.goosuu.code01;

/**
 * 运算符：
 *  算数运算符： + - * / % ++ --
 *  赋值运算符：+= -= *= /= %=
 *  比较运算符： > < == >= <= !=
 *  逻辑运算符：&& || !
 *  三元运算符：条件 ? 值1 : 值2
 *  位运算符(了解)：& | ^ >> <<
 * 规则：数据运算时，结果数据类型为数据范围大的
 */
public class Compute {
    public static void main(String[] args) {
        float i = 3.0F;
        int n = 10;
        System.out.println(n/i);
        String s = "Hello";
        System.out.println(s+n);
        int num = 10;
        System.out.println(num++); //10
        System.out.println(num); //11
        int num2 = 20;
        System.out.println(++num2);  //21
        System.out.println(num2);  //21
        System.out.println(!true);
    }
}
