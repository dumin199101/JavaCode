package com.goosuu.code11.threadsafe;

public class RunnableImpl2 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        System.out.println("锁对象："+this);
        payTicket();
    }

    /*定义同步方法*/
    public synchronized void payTicket() {
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
    }

}
