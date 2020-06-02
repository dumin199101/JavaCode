package com.goosuu.code10;

import java.util.Objects;

public class Student<Student> {

    private int age;

    public <Integer> int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
