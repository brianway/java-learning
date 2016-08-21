package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject3.getInstance().hashCode() + " " + MyObject3.getInstance());
    }
}
