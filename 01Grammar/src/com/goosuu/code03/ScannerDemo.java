package com.goosuu.code03;

import java.util.Scanner;

/**
 * Scanner:键盘输入数据到程序中
 */
public class ScannerDemo {
    public static void main(String[] args) {
        System.out.println("请输入您要输入的信息：");
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        System.out.println("您输入的信息是："+msg);
        System.out.println("请您输入您的年龄：");
        int age = sc.nextInt();
        System.out.println("你的年龄是："+age);
    }
}
