package com.brianway.learning.java.multithread.lock.example6;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P223
 * 测试方法boolean hasWaiters(Condition)
 * 查询是否有线程正在等待与此锁定有关的condition条件
 */
public class Run6_hasWaiters {
    public static void main(String[] args) throws InterruptedException {
        final Service2 service = new Service2();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
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

        service.notifyMethod();
    }
}


/*
输出：
有没有线程正在等待newCondition？true 线程数是多少？10
 */