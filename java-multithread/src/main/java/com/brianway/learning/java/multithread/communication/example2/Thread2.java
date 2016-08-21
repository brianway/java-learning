package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */
public class Thread2 extends Thread {
    private Object lock;

    public Thread2(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            System.out.println("开始 notify time=" + System.currentTimeMillis());
            lock.notify();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}
