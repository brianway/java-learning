package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */
public class Thread1 extends Thread {
    private MyObject1 object1;

    public Thread1(MyObject1 object1) {
        this.object1 = object1;
    }

    @Override
    public void run() {
        super.run();
        object1.speedPrintString();
    }
}
