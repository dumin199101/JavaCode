package com.goosuu.code01;

/**
 * 流程控制：
 *      顺序结构
 *      选择结构
 *      循环结构
 */
public class Sequence {
    public static void main(String[] args) {
        int a = 10;
        if (a == 10) {
            System.out.println("a的值是" + a);
        } else if (a > 10) {
            System.out.println("a的值大于10");
        } else {
            System.out.println("a的值小于10");
        }

        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("你的成绩是A");
                break;
            case 'B':
                System.out.println("你的成绩是B");
                break;
            default:
                System.out.println("你的成绩不及格");

        }

        for (int i=1;i<10;i++){
            System.out.println(i);
        }

        int n = 1;
        while (n<=5) {
            System.out.println("while"+n);
            n++;
        }

        int k = 1;
        do {
            System.out.println("do-while"+k);
            k++;
        } while (k<=3);
    }
}
