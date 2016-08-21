package com.brianway.learning.java.multithread.lock.example8;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P228
 * 测试方法boolean tryLock()
 * 仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定
 */
public class Run8_tryLock {
    public static void main(String[] args) {
        final Service3 service = new Service3();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}

/*
输出：
B获得锁
A没有获得锁

------------------

A获得锁
B没有获得锁
 */