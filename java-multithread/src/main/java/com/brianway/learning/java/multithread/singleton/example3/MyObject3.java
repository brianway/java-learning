package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject3 {

    private static MyObject3 instance = null;

    private MyObject3() {
    }

    static {
        instance = new MyObject3();
    }

    public static MyObject3 getInstance() {
        return instance;
    }
}
