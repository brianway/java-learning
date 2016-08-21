package com.brianway.learning.java.multithread.lock.example5;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P220
 * 测试方法int getQueueLength()
 * 返回正在等待获取此锁定的线程估计数
 */
public class Run5_getQueueLength {
    public static void main(String[] args) throws InterruptedException {
        final Service2 service = new Service2();
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod1();
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        Thread.sleep(2000);

        System.out.println("有线程数：" + service.lock.getQueueLength() + "在等待获取锁");

    }
}


/*
输出：
ThreadName=Thread-0
有线程数：9在等待获取锁
 */