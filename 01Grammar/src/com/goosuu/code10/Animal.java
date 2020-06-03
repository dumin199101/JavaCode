package com.goosuu.code10;

/**
 *   Comparable接口自然排序：
 *      先按年龄排序，年龄相同，再按照姓名自然顺序排序
 *
 */
public class Animal implements Comparable<Animal> {

    private int age;
    private String name;

    public Animal() {
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Animal o) {
        int result = this.getAge() - o.getAge();
        return result == 0 ? this.getName().compareTo(o.getName()) : result;
//        return result == 0 ? this.getName().length() - o.getName().length() : result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
