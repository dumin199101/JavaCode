package com.goosuu.code05;

public class Dog extends Animal {
    public Dog() {
        super();
        System.out.println("Dog类构造方法");
    }

    @Override
    public void eat() {
        System.out.println("狗要吃骨头");
    }
}
