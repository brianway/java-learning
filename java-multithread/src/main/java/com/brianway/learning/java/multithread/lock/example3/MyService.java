package com.brianway.learning.java.multithread.lock.example3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                System.out.println("有可能★★连续" + "  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
                condition.await();
            }
            System.out.println("打印★" + "          时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            hasValue = true;
            //condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("set unlock" + "      时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                System.out.println("有可能☆☆连续" + "  时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
                condition.await();
            }
            System.out.println("打印☆" + "          时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            hasValue = false;
            //condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("get unlock" + "      时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            lock.unlock();
        }
    }

}
