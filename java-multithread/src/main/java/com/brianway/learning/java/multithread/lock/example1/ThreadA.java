package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */
public class ThreadA extends Thread {
    private ServiceA service;

    public ThreadA(ServiceA service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
