package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */
public class Thread1 extends Thread {
    private Object lock;

    public Thread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始 wait   time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
