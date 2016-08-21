package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject3 {
    private static MyObject3 myObject;

    private MyObject3() {
    }

    public static MyObject3 getInstance() {

        try {
            if (myObject == null) {
                Thread.sleep(3000);//模拟创建对象前的坐一些准备
                //虽然部分代码被上锁，但还是有非线程安全问题
                synchronized (MyObject3.class) {
                    myObject = new MyObject3();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
