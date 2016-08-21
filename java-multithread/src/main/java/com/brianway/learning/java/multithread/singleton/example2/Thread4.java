package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread4 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject4.getInstance().hashCode() + " " + MyObject4.getInstance());
    }
}
