package com.brianway.learning.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * TODO 为什么有两个线程?
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}

class ExceptionThread implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e + " in " + t);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}



/* Output: (90% match)
com.brianway.learning.java.concurrent.HandlerThreadFactory@266474c2 creating new Thread
created Thread[Thread-0,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@6f94fa3e
run() by Thread[Thread-0,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@6f94fa3e
com.brianway.learning.java.concurrent.HandlerThreadFactory@266474c2 creating new Thread
created Thread[Thread-1,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@3ff961b5
caught java.lang.RuntimeException in Thread[Thread-0,5,main]
*///:~
