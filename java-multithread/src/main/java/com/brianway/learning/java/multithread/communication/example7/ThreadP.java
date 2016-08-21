package com.brianway.learning.java.multithread.communication.example7;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadP extends Thread {
    private Producer p;

    public ThreadP(Producer p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
