package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
