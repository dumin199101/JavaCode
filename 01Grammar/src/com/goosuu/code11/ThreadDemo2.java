package com.goosuu.code11;

/**
 *
 *   内部类方式实现多线程
 *
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            }
        }).start();
    }
}
