package com.brianway.learning.java.multithread.lock.example7;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P224
 * 测试方法boolean isFair()
 * 判断是不是公平锁
 */
public class Run7_isFair {
    public static void main(String[] args) {
        final Service1 service = new Service1(true);
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        final Service1 service2 = new Service1(false);
        runnable = new Runnable() {
            public void run() {
                service2.serviceMethod();
            }
        };
        thread = new Thread(runnable);
        thread.start();

    }
}

/*
输出：
公平锁情况：true
公平锁情况：false
 */