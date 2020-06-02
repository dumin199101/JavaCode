package com.goosuu.code10;

import java.util.ArrayList;

/**
 * 泛型：
 *     定义：未知的数据类型，创建对象时，数据类型作为参数传递。
 *     不使用泛型缺点：未明确泛型：默认是Object，运行时遍历容易发生异常！
 *     分类：
 *        泛型类
 *          格式：修饰符 class 类名<E>{}
 *        泛型方法
 *          格式：修饰符 <E> 返回值类型 方法名(参数列表){}
 *        泛型接口
 *          格式：修饰符 interface 接口名<E>{}
 *      泛型通配符：
 *          ?:代表任意数据类型，作为方法参数传递。
 *          泛型的上限限定：? extends 类:只能是类跟类的子类
 *          泛型的下限限定：? super 类:只能是类与类的父类
 *
 *
 *
 */
public class FanXingDemo {
    public static void main(String[] args) {
        Student<Student> student1 = new Student();
        student1.setAge(10);
        Student<Student> student2 = new Student();
        student2.setAge(20);
        ArrayList<Student> students = new ArrayList();
        students.add(student1);
        students.add(student2);
        System.out.println(students.toString());
        System.out.println("*****************");
        printArrayList(students);

    }

    public static void printArrayList(ArrayList<?> list){
        for (Object s : list) {
            Student student = (Student) s;
            System.out.println(student.getAge());
        }
    }
}
