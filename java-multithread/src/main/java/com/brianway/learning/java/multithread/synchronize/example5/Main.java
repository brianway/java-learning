package com.brianway.learning.java.multithread.synchronize.example5;

/**
 * Created by Brian on 2016/4/12.
 */
public class Main {
    protected int i = 10;

    synchronized public void operateIinMain() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
