package com.goosuu.code02;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person("wang",22,true);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isSex());
    }
}
