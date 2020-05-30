package com.goosuu.code02;

public class Student {
    String name;
    int age;
    public void eat(){
        System.out.println("eat");
    }
    public void getNameInfo(String name){
        System.out.println(name+"的儿子是"+this.name);
    }
}
