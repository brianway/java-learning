package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject4 {
    private static MyObject4 myObject;

    private MyObject4() {
    }

    public static MyObject4 getInstance() {
        //双检查锁机制
        try {
            if (myObject == null) {
                Thread.sleep(3000);//模拟创建对象前的坐一些准备
                synchronized (MyObject4.class) {
                    if (myObject == null) {
                        myObject = new MyObject4();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
