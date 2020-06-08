package com.goosuu.code15.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        //1.获取成员方法
        Method getAge = personClass.getMethod("getAge");
        Person p = new Person("张三",22);
        int age = (int) getAge.invoke(p);
        System.out.println(age);
        System.out.println(getAge.getName());

        //获取带参数成员方法
        Method setAge = personClass.getMethod("setAge", int.class);
        setAge.invoke(p,25);
        System.out.println(getAge.invoke(p));

        System.out.println("******************************************");
        //获取所有方法
        Method[] methods= personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }


    }
}
