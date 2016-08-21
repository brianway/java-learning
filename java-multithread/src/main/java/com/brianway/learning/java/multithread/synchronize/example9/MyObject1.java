package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */
public class MyObject1 extends MyObject {
    synchronized public void speedPrintString() {
        System.out.println("speedPrintString   ____getLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
        System.out.println("*******************");
        System.out.println("speedPrintString   releaseLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
    }
}
