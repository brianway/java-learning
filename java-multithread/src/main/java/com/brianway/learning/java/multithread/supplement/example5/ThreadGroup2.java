package com.brianway.learning.java.multithread.supplement.example5;

/**
 * Created by Brian on 2016/4/17.
 */
public class ThreadGroup2 extends ThreadGroup {

    public ThreadGroup2(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();
    }
}
