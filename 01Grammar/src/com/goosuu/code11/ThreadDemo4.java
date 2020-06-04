package com.goosuu.code11;

public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable,"Thread1");
        thread1.setDaemon(true);
        thread1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.interrupted();









    }
}
