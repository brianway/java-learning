package com.brianway.learning.java.multithread.communication.example9;

/**
 * Created by Brian on 2016/4/14.
 */
public class P_Thread extends Thread {
    private Producer p;

    public P_Thread(Producer p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.pushService();
        }
    }
}
