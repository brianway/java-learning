package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */
public class ThreadB extends Thread {
    ServiceB serviceB;

    public ThreadB(ServiceB serviceB) {
        super();
        this.serviceB = serviceB;
    }

    @Override
    public void run() {
        serviceB.print(new Object());
    }
}
