package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject2.getInstance().hashCode() + " " + MyObject2.getInstance());
    }
}
