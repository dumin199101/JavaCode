package com.goosuu.code11.threadsafe;

public class ThreadSafeDemo1 {
    public static void main(String[] args) {
        //为了卖同样的10张票，使用共同的runnable实例
        Runnable runnable = new RunnableImpl1();
        Thread t1 = new Thread(runnable,"thread1");
        Thread t2 = new Thread(runnable,"thread2");
        Thread t3 = new Thread(runnable,"thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
