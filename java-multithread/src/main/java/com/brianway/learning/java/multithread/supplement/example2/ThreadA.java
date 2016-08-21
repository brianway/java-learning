package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
