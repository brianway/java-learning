package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */
public class ThreadA extends Thread {
    ServiceA serviceA;

    public ThreadA(ServiceA serviceA) {
        super();
        this.serviceA = serviceA;
    }

    @Override
    public void run() {
        serviceA.print("123");
    }
}
