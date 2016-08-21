package com.brianway.learning.java.multithread.synchronize.example7;

/**
 * Created by Brian on 2016/4/12.
 */
public class MyThread extends Thread {
    private Sub sub;

    public MyThread(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.testMethod();
    }
}
