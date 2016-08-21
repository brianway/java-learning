package com.brianway.learning.java.multithread.communication.example3;

/**
 * Created by brian on 2016/4/14.
 */
public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait(),ThreadName=" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait(),ThreadName=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
