package com.goosuu.code11.threadpool;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
