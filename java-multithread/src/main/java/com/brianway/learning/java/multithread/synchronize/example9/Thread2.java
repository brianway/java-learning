package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */
public class Thread2 extends Thread {
    private MyObject2 object2;

    public Thread2(MyObject2 object2) {
        this.object2 = object2;
    }

    @Override
    public void run() {
        super.run();
        object2.speedPrintString();
    }
}
