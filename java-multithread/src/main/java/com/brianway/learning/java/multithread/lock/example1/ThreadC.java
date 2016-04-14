package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */
public class ThreadC extends Thread {
    private ServiceC service;

    public ThreadC(ServiceC service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
