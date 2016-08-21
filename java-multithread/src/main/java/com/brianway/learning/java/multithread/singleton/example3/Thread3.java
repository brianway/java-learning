package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject3.getInstance().hashCode() + " " + MyObject3.getInstance());
        }

    }
}
