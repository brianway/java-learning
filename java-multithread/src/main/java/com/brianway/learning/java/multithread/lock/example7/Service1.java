package com.brianway.learning.java.multithread.lock.example7;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service1 {
    private ReentrantLock lock;

    public Service1(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("公平锁情况：" + lock.isFair());
        } finally {
            lock.unlock();
        }
    }
}
