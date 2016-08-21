package com.brianway.learning.java.multithread.communication.example14;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P181
 * join的异常
 * 线程b被中断了，但a还在正常运行
 */
public class Run14_joinExption {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            b.start();
            Thread.sleep(500);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
线程B在catch处打印了
java.lang.InterruptedException
	at java.lang.Object.wait(Native Method)
	at java.lang.Thread.join(Thread.java:1245)
	at java.lang.Thread.join(Thread.java:1319)
	at com.brianway.learning.java.multithread.communication.example14.ThreadB.run(ThreadB.java:12)
 */