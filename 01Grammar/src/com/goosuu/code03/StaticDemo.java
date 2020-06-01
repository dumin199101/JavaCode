package com.goosuu.code03;

/**
 * 静态：
 *   静态变量，静态方法是属于类的，是对象间共同享有的变量或方法。
 *   类名.静态变量
 *   类名.静态方法
 *   静态只能访问静态,静态方法中不能使用this
 *   本类中静态方法调用，可以省略类名，编译时会自动补全类名
 *   静态代码块：
 *     当第一次用到本类时，静态代码块执行唯一的一次！
 *     static{}
 *     静态代码块比构造方法先执行
 *   内存方法区中有静态区,存储静态数据
 */
public class StaticDemo {
    public static void main(String[] args) {
        Student s = new Student("wang",22);
        Student s2 = new Student();
        //调用静态变量
        Student.room = "101教室";
        System.out.println(Student.room);
        //调用静态方法
        Student.getRoom();
        //本类调用静态方法，可以省略类名
        eat();

    }

    public static void eat(){
        System.out.println("eat！！！！");
    }
}
