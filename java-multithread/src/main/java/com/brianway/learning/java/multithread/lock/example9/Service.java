package com.brianway.learning.java.multithread.lock.example9;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer=" + System.currentTimeMillis());
            condition.awaitUntil(calendar.getTime());
            System.out.println("wait end   timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("notify begin timer=" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify end   timer=" + System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
    }
}
