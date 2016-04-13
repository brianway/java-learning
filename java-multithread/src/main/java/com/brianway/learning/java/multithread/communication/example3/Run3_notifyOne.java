package com.brianway.learning.java.multithread.communication.example3;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * P149
 * 通知一个线程
 */
public class Run3_notifyOne {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread a = new MyThread(lock);
        a.start();
        MyThread b = new MyThread(lock);
        b.start();
        MyThread c = new MyThread(lock);
        c.start();

        Thread.sleep(1000);

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
    }
}

/*
输出：
begin wait(),ThreadName=Thread-1
begin wait(),ThreadName=Thread-2
begin wait(),ThreadName=Thread-0
end wait(),ThreadName=Thread-1

 */