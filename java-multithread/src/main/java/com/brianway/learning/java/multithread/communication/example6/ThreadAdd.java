package com.brianway.learning.java.multithread.communication.example6;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadAdd extends Thread {
    private Add add;

    public ThreadAdd(String name, Add add) {
        super(name);
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
