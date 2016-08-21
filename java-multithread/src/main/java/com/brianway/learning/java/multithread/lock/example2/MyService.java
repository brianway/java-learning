package com.brianway.learning.java.multithread.lock.example2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by brian on 2016/4/15.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("awaitA begin时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("awaitA end  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("A锁释放了  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("awaitB begin时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("awaitB end  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("B锁释放了  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A 时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
