package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */
public class MyObject2 extends MyObject {
    public void speedPrintString() {
        synchronized (this) {
            System.out.println("speedPrintString   ____getLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
            System.out.println("*******************");
            System.out.println("speedPrintString   releaseLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
        }
    }
}
