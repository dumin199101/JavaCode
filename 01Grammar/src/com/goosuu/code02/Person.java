package com.goosuu.code02;

/**
 * 一个标准的Java类通常有四部分组成：
 *   1.所有的成员变量由private修饰
 *   2.每个成员边梁编写getter/setter方法
 *   3.无参数构造方法
 *   4.带参数构造方法
 *  这样的标准称之为Java Bean。
 */
public class Person {
    private String name;
    private int age;
    private boolean sex;

    public Person() {
    }

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
