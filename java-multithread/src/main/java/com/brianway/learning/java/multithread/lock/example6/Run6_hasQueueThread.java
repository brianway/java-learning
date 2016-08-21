package com.brianway.learning.java.multithread.lock.example6;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P222
 * 测试方法boolean hasQueueThread(Thread thread)
 * 查询指定的线程是否正在等待获取此锁定
 * 测试方法boolean hasQueueThreads()
 * 查询是否有线程正在等待获取此锁定
 */
public class Run6_hasQueueThread {
    public static void main(String[] args) throws InterruptedException {
        final Service1 service = new Service1();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.start();
        Thread.sleep(500);
        System.out.println(service.lock.hasQueuedThread(threadA));
        System.out.println(service.lock.hasQueuedThread(threadB));
        System.out.println(service.lock.hasQueuedThreads());
    }

}


/*
输出：
false
true
true

 */