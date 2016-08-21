package com.brianway.learning.java.multithread.communication.example11;

/**
 * Created by Brian on 2016/4/14.
 */
public class C_Thread extends Thread {
    private Consumer c;

    public C_Thread(Consumer c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }
}
