package com.goosuu.code04;

public class Son extends Father {
    public Son() {
        super(29);
        System.out.println("子类构造方法");
    }

    public Son(int age){
        this();
        System.out.println("子类带参数构造方法"+age);
    }

    public int age = 22;
    @Override
    public void getAge(){
        int age = 20;
        System.out.println(age);
        System.out.println(this.age);
        System.out.println(super.age);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("娶媳妇");
        System.out.println("生孩子");
    }
}
