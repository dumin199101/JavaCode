package com.goosuu.code15.reflect;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        //1.获取成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field city = personClass.getField("city");
        Person p = new Person();
        System.out.println(city.get(p));
        city.set(p,"北京");
        System.out.println(city.get(p));

        System.out.println("******************************");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name = personClass.getDeclaredField("name");
        //暴力反射
        name.setAccessible(true);
        System.out.println(name.get(p));



    }
}
