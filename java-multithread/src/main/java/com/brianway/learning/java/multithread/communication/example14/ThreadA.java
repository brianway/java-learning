package com.brianway.learning.java.multithread.communication.example14;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String newString = new String();
            Math.random();
        }
    }
}
