package com.brianway.learning.java.multithread.supplement.example4;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P298
 * 线程中出现异常，捕捉
 */
public class Run4_threadCreateException2 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.setName("thread t1");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程:" + t.getName() + " 出现了异常：");
                e.printStackTrace();
            }
        });
        t1.start();
        Thread1 t2 = new Thread1();
        t2.setName("thread t2");
        t2.start();

    }
}

/*
输出：
线程:thread t1 出现了异常：
Exception in thread "thread t2" java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example4.Thread1.run(Thread1.java:10)
java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example4.Thread1.run(Thread1.java:10)

------------------------------

Exception in thread "thread t2" 线程:thread t1 出现了异常：
java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example4.Thread1.run(Thread1.java:10)
java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example4.Thread1.run(Thread1.java:10)

 */