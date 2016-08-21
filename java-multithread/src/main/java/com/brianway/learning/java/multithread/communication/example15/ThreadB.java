package com.brianway.learning.java.multithread.communication.example15;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("b run begin timer=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("b run end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印了bService timer=" + System.currentTimeMillis());
    }

}

