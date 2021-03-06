package com.goosuu.code11.threadsafe;

public class RunnableImpl1 implements Runnable {

    private int ticket = 100;

    //创建一个锁对象
    Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
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
}
