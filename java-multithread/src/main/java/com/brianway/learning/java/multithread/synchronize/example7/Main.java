package com.brianway.learning.java.multithread.synchronize.example7;

/**
 * Created by Brian on 2016/4/12.
 */
public class Main {
    synchronized public void testMethod() {
        try {
            System.out.println("threadName= " + Thread.currentThread().getName() + " in main 下一步 sleep begin time =" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("threadName= " + Thread.currentThread().getName() + " in main 下一步 sleep end time =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
