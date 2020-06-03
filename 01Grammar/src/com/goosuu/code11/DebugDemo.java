package com.goosuu.code11;

/**
 * Debug调试：
 * F8：逐行执行代码
 * F7：进入到方法
 * shift+F8：跳出方法
 * F9：跳到下一个断点
 * ctrl+F2:退出Debug
 */
public class DebugDemo {
    public static void main(String[] args) {
        int result = sum(1, 2, 3);
        System.out.println(result);
        int result2 = sum(1, 2, 3, 4);
        System.out.println(result2);
        int result3 = sum(1, 2, 3, 4, 5);
        System.out.println(result3);
        int result4 = sum(1, 2, 3, 6);
        System.out.println(result4);
    }

    public static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }
}
