package com.goosuu.code04;

/**
 *  继承：
 *   访问变量：
 *      局部变量：变量名
 *      成员变量：this.变量名
 *      父类成员变量：super.变量名
 *
 *   成员变量重名访问:
 *     子类对象直接访问：等号左边是谁就优先访问谁，没有就向上找
 *     成员方法间接访问：通过方法访问，方法属于谁，就优先访问谁，没有就向上找
 *
 *   方法重写：在继承关系中方法名称相同，参数列表相同
 *   访问规则：优先访问子类重名方法，没有就向上找
 *   @override:写在方法前面，检测是否是合法的覆盖方法。@代表注解
 *   子类权限修饰符大于等于父类（public>protected>default>private）【了解】
 *   子类返回值小于等于父类返回值范围【了解】
 *
 *   构造方法：
 *     子类默认会自动调用父类无参构造方法，使用super()进行调用
 *
 *
 *
 *
 */
public class ExtendDemo {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.age);
        son.getAge();
        Father father = new Father();
        father.getAge();
        son.show();
    }
}
