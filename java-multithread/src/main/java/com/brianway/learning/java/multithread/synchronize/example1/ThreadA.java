package com.brianway.learning.java.multithread.synchronize.example1;

/**
 * Created by Brian on 2016/4/11.
 */
public class ThreadA extends Thread {
    private HasLocalNum numRef;

    public ThreadA(HasLocalNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
