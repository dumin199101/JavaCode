package com.goosuu.code04;

public class Father {
    public Father() {
        System.out.println("父类构造方法");
    }

    public Father(int age) {
        System.out.println("父类构造方法"+age);
    }

    public int age = 41;
    public void getAge(){
        System.out.println(age);
    }
    public void show(){
        System.out.println("盖房子");
    }
}
