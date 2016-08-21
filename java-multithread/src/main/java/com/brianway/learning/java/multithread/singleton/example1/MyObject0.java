package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * 缺点：不能有其他实例变量
 * getInstance()方法没有同步，可能出现非线程安全问题
 */
public class MyObject0 {
    private static MyObject0 myObject = new MyObject0();

    private MyObject0() {
    }

    public static MyObject0 getInstance() {
        return myObject;
    }
}
