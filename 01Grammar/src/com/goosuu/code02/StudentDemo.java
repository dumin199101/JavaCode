package com.goosuu.code02;

/**
 *  类：
 *    成员变量
 *    成员方法：不能使用static
 *  导包：
 *    import 包名.类名
 *  如果类与当前类在同一个包，可以省略导包
 *  成员变量跟局部变量同名同时出现时,使用就近原则，优先使用局部变量
 *
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.name);
        System.out.println(s.age);
        s.eat();
        s.name = "郑伟";
        s.age = 22;
        System.out.println(s.name);
        System.out.println(s.age);
        s.getNameInfo("王伟");
    }
}


