package com.brianway.learning.java.multithread.lock.example8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service3 {
    public ReentrantLock lock = new ReentrantLock();

    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
        }
    }
}
