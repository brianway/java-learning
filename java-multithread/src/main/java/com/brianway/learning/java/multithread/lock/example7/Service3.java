package com.brianway.learning.java.multithread.lock.example7;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service3 {
    private ReentrantLock lock;

    public Service3(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
        } finally {
            lock.unlock();
        }
    }
}
