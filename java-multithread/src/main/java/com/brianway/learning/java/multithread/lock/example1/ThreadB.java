package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */
public class ThreadB extends Thread {
    private ServiceB service;

    public ThreadB(ServiceB service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
