package com.brianway.learning.java.multithread.synchronize.example4;

/**
 * Created by Brian on 2016/4/12.
 */
public class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}