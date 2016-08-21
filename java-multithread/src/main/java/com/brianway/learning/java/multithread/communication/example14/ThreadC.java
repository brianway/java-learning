package com.brianway.learning.java.multithread.communication.example14;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadC extends Thread {

    private ThreadB b;

    public ThreadC(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        b.interrupt();
    }
}
