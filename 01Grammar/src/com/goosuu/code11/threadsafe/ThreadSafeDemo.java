package com.goosuu.code11.threadsafe;

public class ThreadSafeDemo {
    public static void main(String[] args) {
        //为了卖同样的100张票，使用共同的runnable实例
        Runnable runnable = new RunnableImpl();
        Thread t1 = new Thread(runnable,"thread1");
        Thread t2 = new Thread(runnable,"thread2");
        Thread t3 = new Thread(runnable,"thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
