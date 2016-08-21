package com.brianway.learning.java.multithread.lock.example9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service2 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();
            System.out.println("wait end");
        } finally {
            lock.unlock();
        }
    }
}
