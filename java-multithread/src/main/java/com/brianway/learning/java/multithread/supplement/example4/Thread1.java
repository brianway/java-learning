package com.brianway.learning.java.multithread.supplement.example4;

/**
 * Created by Brian on 2016/4/17.
 */
public class Thread1 extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}
