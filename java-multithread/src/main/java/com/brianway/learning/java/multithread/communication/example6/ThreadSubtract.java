package com.brianway.learning.java.multithread.communication.example6;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadSubtract extends Thread {
    private Subtract subtract;

    public ThreadSubtract(String name, Subtract subtract) {
        super(name);
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }
}
