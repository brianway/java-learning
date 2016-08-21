package com.brianway.learning.java.multithread.communication.example3;

/**
 * Created by brian on 2016/4/14.
 */
public class NotifyThread2 extends Thread {
    private Object lock;

    public NotifyThread2(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();

        }
    }
}
