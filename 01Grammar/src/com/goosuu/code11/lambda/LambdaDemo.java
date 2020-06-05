package com.goosuu.code11.lambda;

/**
 * Lambda表达式：
 *    实质：函数接口
 *    语法：(参数列表)->{接口方法体}
 *    注意：这里传递的参数是接口中重写方法的参数
 *    简写形式：
 *      1.参数只有一个可以省略小括号
 *      2.参数数据类型可省略
 *      3.方法体只有一条,可省略return、{}、；、
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"---"+i);
            }
        }).start();

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
