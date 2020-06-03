package com.goosuu.code10;

/**
 *  可变参数：
 *    JDK1.5+
 *    格式：方法名(数据类型...参数)
 *
 */
public class VarArgsDemo {
    public static void main(String[] args) {
        int result = sum(1, 2, 3);
        System.out.println(result);
        int result2 = sum(1, 2, 3,6);
        System.out.println(result2);
    }

    public static int sum(int...args){
        int sum = 0;
        for (int arg:args) {
            sum = sum + arg;
        }
        return sum;
    }
}
