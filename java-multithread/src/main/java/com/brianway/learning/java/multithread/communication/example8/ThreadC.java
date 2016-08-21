package com.brianway.learning.java.multithread.communication.example8;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadC extends Thread {
    private Consumer c;

    public ThreadC(Consumer c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
