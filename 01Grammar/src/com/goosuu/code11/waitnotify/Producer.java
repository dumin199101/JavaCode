package com.goosuu.code11.waitnotify;

/**
 *
 *  生产者
 *
 */
public class Producer extends Thread {
    private Baozi baozi;

    public Producer(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baozi){
                if(baozi.flag==true){
                    //如果有包子，那么就等消费者吃包子
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果没有包子,就生产包子
                baozi.pi = "薄皮";
                baozi.xian = "猪肉";
                //模拟生产包子过程
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //生产完包子，改变标识
                baozi.flag = true;
                baozi.notify(); //通知消费者吃包子
                System.out.println("生产者生产包子：包子信息：皮："+baozi.pi+",馅："+baozi.xian);
            }
        }
    }
}
