package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject4.ObjectFactory.getObject().hashCode() + " " + MyObject4.ObjectFactory.getObject());
        }

    }
}
