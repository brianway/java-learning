package com.brianway.learning.java.multithread.lock.example10;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * TODO
 * 这里为什么用双try?
 * 以前不都是直接try catch finally的吗？
 */
public class Service1 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
