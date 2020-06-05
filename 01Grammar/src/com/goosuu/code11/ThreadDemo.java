package com.goosuu.code11;

/**
 *  并行、并发：
 *     并行：一段时间内同时执行
 *     并发：一段时间内交替执行
 *  进程、线程：
 *     进程：正在执行的程序
 *     线程：进程的执行的最小单元
 *  多线程：
 *     单核单线程：并发
 *     多核多线程：并行
 *  线程调度方式：抢占式
 *  多线程实现方式：
 *     1.继承Thread类
 *     2.实现Runnable接口
 *     3.线程池
 *
 *  常用方法：
 *    sleep()：线程休眠
 *    interrupted():结束线程
 *    setDaemon()：守护线程，随主线程消亡而消亡，start之前调用。
 *    join():等待当前线程执行完，再执行其它线程
 *    yield()：让出当前cpu的资源给其它线程，与sleep类似
 *    getName()：获取线程名
 *    setName()：设置线程名
 *    currentThread()：当前线程
 *
 *  线程安全问题：
 *    概述：多线程访问共享数据，会产生线程安全问题
 *    以卖票为例：
 *      1.出现了重复的票
 *      2.出现了0票跟负数票
 *    解决：
 *      线程同步，同一时刻只有一个线程在卖票
 *      问题：每次执行前判断是否同步，会降低程序执行效率。
 *      1.同步代码块
 *         格式：synchronized(锁对象){}
 *         同步代码块中的锁对象可以是任意对象，多个线程间锁对象必须一致
 *      2.同步方法
 *         格式：修饰符 synchronized 返回值 方法名(){}
 *         同步方法的锁对象就是Runnable接口的实现类对象
 *      3.使用Lock锁
 *         可以明确在哪加锁与释放锁
 *         Lock接口实现类：ReentrantLock
 *         1.lock():获取锁
 *         2.unlock()：释放锁
 *
 *    线程间通讯：
 *      线程状态：
 *         新建状态[New]--->start()--->运行状态[Runnable]
 *         新建状态[New]--->start()--->阻塞状态[blocked]
 *         运行状态[Runnable]--->线程间抢夺CPU执行权--->阻塞状态[blocked]
 *         运行状态[Runnable]--->sleep(time)/wait(time)--->休眠状态
 *         休眠状态--->休眠时间到或CPU空闲--->运行状态[Runnable]
 *         运行状态[Runnable]--->run()结束或者interrupted()--->死亡状态[terminated]
 *         运行状态[Runnable]--->wait()--->无限等待状态[Waiting]
 *         无限等待状态[Waiting]--->notify()--->运行状态[Runnable]
 *      等待唤醒机制：
 *         等待方法：sleep(),wait()
 *         唤醒方法：notify(),notifyAll();
 *         构成：生产者类、消费者类、共享数据类、测试类
 *         注意：1.wait与notify必须使用同一个锁对象调用2.必须在同步代码块或同步函数中使用
 *
 *      线程池：
 *         java.util.concurrent.Executors类
 *         java.util.concurrent.ExecutorService类
 *         static ExecutorService newFiexedThreadPool(int threads)
 *         submit(runnable接口实现类对象)：开始任务
 *         shutdown():结束任务，一般不用调用
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //打印线程名
        System.out.println(Thread.currentThread().getName());
        //线程创建方式1
        MyThread myThread = new MyThread();
        myThread.start();

        //线程创建方式2
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }
}
