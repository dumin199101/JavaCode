package com.goosuu.code01;

/**
 * 方法定义：
 *   修饰符 返回值类型 方法名([参数类型 参数列表]){
 *       方法体
 *       返回值
 *   }
 *   方法重载：
 *      方法名字相同，但是如果一下要素不同，称为方法重载：
 *         1.参数列表个数不同
 *         2.参数数据类型不同
 *         3.不同类型参数顺序不同
 *      方法重载与返回值类型无关。
 */
public class Method {
    public static void main(String[] args) {
        say();
    }

    public static void say(){
        System.out.println("说活!!!");
    }

    public static int sum(int a,int b){
        return a + b;
    }

    public static int sum(int a,int b,int c){
        return a + b + c;
    }

    public static double sum(double a,double b){
        return a + b;
    }

    public static double sum(int a,double b){
        return a + b;
    }

    public static double sum(double a,int b){
        return a + b;
    }
}
