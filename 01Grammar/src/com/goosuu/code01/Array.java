package com.goosuu.code01;

/**
 * 数组：
 * 引用数据类型
 * 数组中的数据数据类型必须一致
 * 数组的长度不可改变
 * 数组初始化：
 * 1.动态初始化（指定长度）
 * 数据类型 [] 数组名称 = new 数据类型[数组长度]
 * 2.静态初始化（指定内容）
 * 数据类型[] 数组名称 = new 数据类型[] {元素内容}
 * 省略格式：
 * 数据类型[] 数组名称 = {元素内容}
 * 数组元素访问：
 * 直接打印数组，得到的是数组内存地址hash值
 * 动态初始化数组，默认值：
 * 整型：0
 * 浮点型：0.0
 * 布尔值型：false
 * 字符型：\u0000
 * 引用类型：null
 * Java内存：
 *   栈：局部变量，方法的运行。
 *   堆：new 出来的东西都在堆中存储。
 *   方法区：class信息，方法的信息。
 * 数组异常：
 *   越界异常
 *   空指针异常
 * 数组长度：length
 */
public class Array {
    public static void main(String[] args) {
        //动态初始化
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(arr[1]);
        //静态初始化
        int[] arr2 = new int[] {1,4,6,8};
        System.out.println(arr2[2]);
        //静态初始化：省略格式
        int[] arr3 = {2,45,78,221};
        System.out.println(arr3[3]);

        //两个数组指向同一个内存地址
        int[] arr4 = new int[3];
        System.out.println(arr4);
        System.out.println(arr4[0]);
        System.out.println(arr4[1]);
        System.out.println(arr4[2]);
        arr4[1] = 10;
        System.out.println(arr4[1]);
        int[] arr5 = arr4;  //同时指向内存地址0x0001
        arr5[1] = 30;
        System.out.println(arr4[1]);
        System.out.println(arr4.length);
        //数组遍历：
        System.out.println("***************");
        for (int i = 0;i<arr4.length;i++){
            System.out.println(arr4[i]);
        }






    }
}
