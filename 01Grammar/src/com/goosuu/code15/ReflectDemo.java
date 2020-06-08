package com.goosuu.code15;

import com.goosuu.code15.reflect.Person;

/**
 *   Java反射机制：
 *      1.源代码阶段：.java--->.class
 *      2.Class类对象阶段:
 *          Class类对象：
 *             Field：成员变量
 *             Method：成员方法
 *             Constructor：构造方法
 *      3.运行时阶段:new Object()
 *
 *      .class通过类加载器（ClassLoader）进内存，进入Class类对象阶段
 *          class类对象获取类加载器：ClassLoader getClassLoader():
 *          classLoader类加载器获取输入流：InputStream getResourceAsStream(String name)
 *
 *
 *      获取Class对象方式：
 *        1.源代码阶段：Class.forName("全类名")
 *        2.Class类对象阶段：类名.class
 *        3.运行时阶段：对象.getClass()
 *
 *      Class对象功能：
 *         成员变量：
 *            Field[] getFields():获取所有public修饰的成员变量
 *            Field getField(String name)
 *            Field[] getDeclaredFields():获取所有的成员变量
 *            Field getDeclaredField​(String name)
 *         成员方法：
 *            getMethods()
 *            getMethod​(String name, Class<?>... parameterTypes)
 *            getDeclaredMethods​()
 *            getDeclaredMethod​(String name, Class<?>... parameterTypes)
 *
 *         构造方法：
 *            Constructor<?>[] getConstructors​()
 *            Constructor<T> getConstructor​(Class<?>... parameterTypes)
 *            Constructor<?>[] getDeclaredConstructors​()
 *            Constructor<T> getDeclaredConstructor​(Class<?>... parameterTypes)
 *
 *
 *         获取类名：
 *            String getName():全路径
 *
 *         Field类:
 *           get(Object o):返回由该 Field表示的字段在指定对象上的值。
 *           set(Object o,Object value):将指定的对象参数中由此 Field对象表示的字段设置为指定的新值。
 *           setAccessible(boolean b):忽略权限修饰符安全检查
 *           getName():获取成员变量名称
 *
 *        Constructor类：
 *          T newInstance(Object...args):创建新实例
 *          setAccessible(boolean b):忽略权限修饰符安全检查
 *          getName():获取构造方法名称
 *
 *        Method类：
 *          invoke(Object o):执行方法
 *          invoke(Object o,args):执行方法
 *          setAccessible(boolean b):忽略权限修饰符安全检查
 *          getName():获取方法名称
 *
 *
 *
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("com.goosuu.code15.reflect.Person");
        System.out.println(cls1);
        //2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass()
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        System.out.println(cls1.getName());

    }
}
