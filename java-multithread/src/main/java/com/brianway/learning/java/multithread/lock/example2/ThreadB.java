package com.brianway.learning.java.multithread.lock.example2;

/**
 * Created by Brian on 2016/4/15.
 */
public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
