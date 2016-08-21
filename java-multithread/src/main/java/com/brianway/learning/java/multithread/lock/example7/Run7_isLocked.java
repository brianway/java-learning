package com.brianway.learning.java.multithread.lock.example7;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P226
 * 测试方法boolean isLocked()
 * 查询此锁定是否由任意线程保持
 */
public class Run7_isLocked {
    public static void main(String[] args) {
        final Service3 service = new Service3(true);
        Runnable runnable = new Runnable() {
            public void run() {
                service.serviceMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}


/*
输出：
false
true
 */