package com.goosuu.code01;

/**
 * 变量声明：  数据类型 变量名
 * 变量初始化： 变量名 = 值
 * 数据类型：
 * 基本数据类型（4种8类）：
 * 整型：byte(1个字节) short（2个字节） int（4个字节） long（8个字节）
 * 浮点型：float（4个字节） double（8个字节）
 * 布尔型：boolean（1个字节）
 * 字符型：char（2个字节）
 * 引用数据类型:
 * 字符串、类、接口、数组
 * 声明变量只能在作用域内使用
 */
public class Variable {
    public static void main(String[] args) {
        int num;
        num = 10;
        System.out.println(num);
        byte num2 = 20;
        System.out.println(num2);
        short num3 = 30;
        System.out.println(num3);
        long num4 = 1000L;
        System.out.println(num4);
        float num5 = 1.2F;
        System.out.println(num5);
        double num6 = 3.5;
        System.out.println(num6);
        boolean b = true;
        System.out.println(b);
        char a = '中';
        System.out.println(a);
        {
            int num7 = 200;
            System.out.println(num7);
        }
        //不能在作用域外打印num7
        int num8 = 10,num9 = 20,num10 = 30;
        System.out.println(num8);
        System.out.println(num9);
        System.out.println(num10);
    }
}
