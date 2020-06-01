package com.goosuu.code08;

/**
 *
 * final可以修饰：
 *   类：
 *     格式：public final class
 *     用途：当前类不能有任何子类
 *   成员变量：final修饰成员变量必须手动赋值，且不能改变！
 *   局部变量：final修饰局部变量不能被修改
 *        引用类型不可变是地址值不可变
 *        基本类型不可变是数据不可变
 *   成员方法：final修饰成员方法不能被子类被重写
 *
 *
 */
public class FinalDemo {
    public static final int a = 1;
    public static void main(String[] args) {
      final int a = 20;
      System.out.println(a);
    }
}
