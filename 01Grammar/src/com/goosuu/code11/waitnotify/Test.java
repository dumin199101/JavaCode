package com.goosuu.code11.waitnotify;

/**
 *
 *  测试类：
 *    生产者生产包子，消费者消费包子
 *
 */
public class Test {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();
        Producer producer = new Producer(baozi);
        Consumer consumer = new Consumer(baozi);
        consumer.start();
        producer.start();
    }
}
