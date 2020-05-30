package com.goosuu.code03;

import com.goosuu.code02.Student;

/**
 * 匿名对象：如果一个对象只使用唯一的一次，那么我们就可以使用匿名对象。
 *   格式：new 类名称();
 */
public class AnonymousDemo {
    public static void main(String[] args) {
        new Student().eat();
    }
}
