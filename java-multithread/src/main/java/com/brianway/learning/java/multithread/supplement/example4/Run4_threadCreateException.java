package com.brianway.learning.java.multithread.supplement.example4;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P297
 * 线程中出现异常
 */
public class Run4_threadCreateException {
    public static void main(String[] args) {
        Thread1 t = new Thread1();
        t.start();
    }
}

/*
输出：
Exception in thread "Thread-0" java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example4.Thread1.run(Thread1.java:10)
 */