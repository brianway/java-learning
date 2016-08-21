package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject1 {
    private static class MyObjectHandler {
        private static MyObject1 myObject = new MyObject1();
    }

    private MyObject1() {
    }

    synchronized public static MyObject1 getInstance() {
        return MyObjectHandler.myObject;
    }
}
