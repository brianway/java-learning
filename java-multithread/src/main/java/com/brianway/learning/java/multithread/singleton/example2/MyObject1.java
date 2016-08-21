package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject1 {
    private static MyObject1 myObject;

    private MyObject1() {
    }

    synchronized public static MyObject1 getInstance() {

        try {
            if (myObject == null) {
                Thread.sleep(3000);//模拟创建对象前的坐一些准备
                myObject = new MyObject1();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
