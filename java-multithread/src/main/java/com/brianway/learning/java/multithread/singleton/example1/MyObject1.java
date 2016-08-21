package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject1 {
    private static MyObject1 myObject;

    private MyObject1() {
    }

    public static MyObject1 getInstance() {
        //延迟加载
        if (myObject == null) {
            myObject = new MyObject1();
        }
        return myObject;
    }
}
