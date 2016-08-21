package com.brianway.learning.java.multithread.lock.example5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian on 2016/4/15.
 */
public class Service2 {
    public ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
