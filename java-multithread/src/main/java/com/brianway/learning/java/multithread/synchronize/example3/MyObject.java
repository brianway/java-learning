package com.brianway.learning.java.multithread.synchronize.example3;

/**
 * Created by Brian on 2016/4/12.
 */

public class MyObject {
    synchronized
    public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "  end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
