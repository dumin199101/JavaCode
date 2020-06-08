package com.goosuu.code15.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *  解析注解：
 *
 *
 */
@MyAnnotation(className = "com.goosuu.code15.annotation.Demo2",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取注解对象,内存中自动生成了一个该接口实现类，并实现该接口
        MyAnnotation annotation = reflectTestClass.getAnnotation(MyAnnotation.class);
        //3.调用注解对象中的抽象方法，获取返回值
        String s = annotation.className();
        String s1 = annotation.methodName();
        System.out.println(s);
        System.out.println(s1);

        //加载该类到内存
        Class cls = Class.forName(s);
        //创建对象
        Object o = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(s1);
        //调用方法
        method.invoke(o);




    }
}
