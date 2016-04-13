package com.brianway.learning.java.multithread.communication.example3;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * P150
 * 唤醒多个线程，(逆序？试了好多次，全部都是刚好逆序的。巧合？机制？)
 */
public class Run3_notifyAll {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread a = new MyThread(lock);
        a.start();
        MyThread b = new MyThread(lock);
        b.start();
        MyThread c = new MyThread(lock);
        c.start();

        Thread.sleep(1000);

        NotifyThread3 notifyThread = new NotifyThread3(lock);
        notifyThread.start();
    }
}

/*
输出：
begin wait(),ThreadName=Thread-0
begin wait(),ThreadName=Thread-1
begin wait(),ThreadName=Thread-2
end wait(),ThreadName=Thread-2
end wait(),ThreadName=Thread-1
end wait(),ThreadName=Thread-0

 */