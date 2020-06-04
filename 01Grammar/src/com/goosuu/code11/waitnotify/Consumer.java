package com.goosuu.code11.waitnotify;

/**
 *
 *   消费者类
 *
 */
public class Consumer extends Thread{
    private Baozi baozi;
    public Consumer(Baozi baozi) {
        this.baozi = baozi;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (baozi) {
                if(baozi.flag==false){
                   //如果没有包子，消费者就等待生产者生产包子
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果有包子，消费者就消费
                System.out.println("消费者吃包子,包子信息：皮："+baozi.pi+",馅："+baozi.xian);
                //吃完包子，通知生产者生产包子
                baozi.flag = false;//消费完包子，改变标识
                baozi.notify(); //通知生产者生产包子
                System.out.println("包子没有了，生产者开始生产包子吧");
                System.out.println("----------------------------");
            }
        }
    }
}
