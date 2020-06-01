package com.goosuu.code07;

/**
 * 多态：对象有多种形态！类继承与接口实现是多态的前提。
 *      表现：
 *        ①父类引用指向子类对象
 *        ②接口指向接口实现类
 * 好处：右边的子类对象无论发生什么变化，左边都不会发生变化！
 * 成员方法：
 *      口诀：编译看左边，运行看右边
 * 多态：
 *    向上转型：父类 对象名 = new 子类
 *            向上转型一定是安全的,无法调用子类特有方法
 *    向下转型: 子类 对象名 = （子类） 父类对象
 *            调用子类特有方法
 * instanceof:判断是否是类的实例
 *   对象 instancof 类
 *
 *
 */
public class DuoTaiDemo {
    public static void main(String[] args) {
        // 向上转型
        Person student = new Student();
        System.out.println(student.num);
        student.eat();
        // 向下转型
        Student s = (Student) student;
        s.sleep();
        System.out.println(student instanceof Student);


    }
}
