package com.goosuu.code05;
/**
 * 抽象类：无需具体实现，在子类中具体实现
 * 抽象方法：加上abstract关键字，去掉大括号
 * 注意
 *   1.不能直接创建抽象类对象
 *   2.必须由子类继承抽象类来具体实现
 *   3.子类必须重写抽象类中的抽象方法
 *   4.创建子类对象进行使用
 */
public class AbstractDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
    }
}
