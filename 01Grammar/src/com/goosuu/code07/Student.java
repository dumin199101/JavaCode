package com.goosuu.code07;

public class Student extends Person {
    public int num = 20;

    @Override
    public void eat() {
        System.out.println("学生吃饭要规律");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}
