package com.goosuu.code11;

public class ThreadDemo5 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable,"Thread1");
        MyRunnable myRunnable2 = new MyRunnable();
        Thread thread2 = new Thread(myRunnable2,"Thread2");
        MyRunnable myRunnable3 = new MyRunnable();
        Thread thread3 = new Thread(myRunnable3,"Thread3");


        thread1.start();
        thread1.yield();
        thread2.start();
        thread3.start();







    }
}
