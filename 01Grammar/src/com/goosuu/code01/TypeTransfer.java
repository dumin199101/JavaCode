package com.goosuu.code01;

/**
 * 数据类型转换:
 *    自动类型转换（隐式转换）：
 *        规则：数据范围从小到大转换，与字节数不一定相关
 *    强制类型转换（显示转换）：
 *        规则：范围小数据类型 变量 = （范围小数据类型） 变量
 *        缺点：会造成数据溢出，精度损失
 *    byte、short、char三种数据类型做数学运算时会自动转换为int类型运算
 *    byte、short、char三种数据类型，右侧赋值如果没有超过范围，那么会自动强转为对应类型
 *    常量优化：变量赋值时，如果右侧全是常量，编译器会自动计算常量值赋值给左侧变量,
 *    boolean不能发生数据类型转换
 *
 */
public class TypeTransfer {
    public static void main(String[] args) {
        // int ---> long 符合从小到大的转换规则
        long num1 = 100;
        System.out.println(num1);
        // float ---> double
        double num2 = 3.14F;
        System.out.println(num2);
        // long ---> float
        float num3 = 30L;
        System.out.println(num3);
        // long ---> int
        int num4 = (int) 10L;
        System.out.println(num4);
        // long ---> int
        int num5 = (int) 6000000000L;
        System.out.println(num5);
        // float ---> int
        int num6 = (int) 3.5F;
        System.out.println(num6);

        byte num7 = 30;
        byte num8 = 40;
        // int = (int) byte + (int) byte
        int result = num7 + num8;
        System.out.println(result);

        char num9 = 'A';
        int result2 = num9 + 1;
        System.out.println(result2);

        short result3 = 5 + 8;
        System.out.println(result3);

    }

}
