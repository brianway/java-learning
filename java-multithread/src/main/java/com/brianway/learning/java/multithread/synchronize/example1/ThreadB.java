package com.brianway.learning.java.multithread.synchronize.example1;

/**
 * Created by Brian on 2016/4/11.
 */
public class ThreadB extends Thread {
    private HasLocalNum numRef;

    public ThreadB(HasLocalNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
