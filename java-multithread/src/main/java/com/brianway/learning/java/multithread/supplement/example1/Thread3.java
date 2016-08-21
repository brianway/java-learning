package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */
public class Thread3 extends Thread {

    @Override
    public void run() {
        MyService.serviveMethod();
    }
}
