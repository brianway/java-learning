package com.brianway.learning.java.multithread.lock.example6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service2 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            //System.out.println("before await "+Thread.currentThread().getName());
            newCondition.await();
            //System.out.println("after  await "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有没有线程正在等待newCondition？" + lock.hasWaiters(newCondition) + " 线程数是多少？" + lock.getWaitQueueLength(newCondition));
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
