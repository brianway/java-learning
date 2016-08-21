package com.brianway.learning.java.multithread.communication.example5;

/**
 * Created by brian on 2016/4/14.
 */
public class MyRun {
    private Object lock = new Object();
    private boolean isFirstRunNotify = false;
    public Runnable runnableWait = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    while (!isFirstRunNotify) {
                        System.out.println("wait begin timer=" + System.currentTimeMillis());
                        lock.wait();
                        System.out.println("wait end timer=" + System.currentTimeMillis());
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public Runnable runnableNotify = new Runnable() {
        public void run() {

            synchronized (lock) {
                System.out.println("notify begin timer=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end timer=" + System.currentTimeMillis());
                isFirstRunNotify = true;
            }

        }
    };
}
