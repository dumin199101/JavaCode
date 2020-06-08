package com.goosuu.code15.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        //1.获取构造方法
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p = constructor.newInstance("张三", 22);
        System.out.println(p.getName()+"----"+p.getAge());

        //空参数构造(已过时)：
        Person person = personClass.newInstance();
        person.setName("李四");
        person.setAge(23);
        System.out.println(person.getName()+"----"+person.getAge());






    }
}
