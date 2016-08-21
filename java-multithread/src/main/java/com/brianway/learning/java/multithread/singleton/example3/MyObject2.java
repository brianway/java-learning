package com.brianway.learning.java.multithread.singleton.example3;

import java.io.Serializable;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject2 implements Serializable {
    private static class MyObjectHandler {
        private static final MyObject2 myObject = new MyObject2();
    }

    private MyObject2() {
    }

    synchronized public static MyObject2 getInstance() {
        return MyObjectHandler.myObject;
    }

    protected Object readResolve() {
        System.out.println("调用了readResolve方法");
        return MyObjectHandler.myObject;
    }
}
