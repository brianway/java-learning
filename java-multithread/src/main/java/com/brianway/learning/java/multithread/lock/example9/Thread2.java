package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */
public class Thread2 extends Thread {
    private Service2 service;

    public Thread2(Service2 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
