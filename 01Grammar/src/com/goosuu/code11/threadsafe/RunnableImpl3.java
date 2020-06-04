package com.goosuu.code11.threadsafe;


import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl3 implements Runnable {

    private int ticket = 10;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        while (ticket > 0) {
            //为了提高线程安全问题出现的概率
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
            ticket--;
        }
        lock.unlock();
    }
}
