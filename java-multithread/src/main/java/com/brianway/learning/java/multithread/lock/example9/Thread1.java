package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */
public class Thread1 extends Thread {
    private Service1 service;

    public Thread1(Service1 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
