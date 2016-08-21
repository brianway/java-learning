package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread0 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject0.getInstance().hashCode() + " " + MyObject0.getInstance());
    }
}
