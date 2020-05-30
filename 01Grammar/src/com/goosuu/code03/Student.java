package com.goosuu.code03;

public class Student {
    private String name;
    private int age;
    public static String room;

    public Student() {
        System.out.println("构造方法执行");
    }

    public Student(String name, int age) {
        System.out.println("构造方法执行！！！");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void getRoom(){
        System.out.println("我们是同班同学，教室是"+Student.room);
    }

    static {
        System.out.println("静态代码块被执行");
    }
}
