package com.brianway.learning.java.multithread.supplement.example6;

/**
 * Created by Brian on 2016/4/17.
 */

import java.lang.Thread.UncaughtExceptionHandler;

public class ObjectUncaughtExceptionHandler implements UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("对象的异常处理");
        e.printStackTrace();
    }
}
