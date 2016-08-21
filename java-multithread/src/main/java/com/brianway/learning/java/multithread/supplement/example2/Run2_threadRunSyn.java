package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P291
 * 使线程具有有序性
 */
public class Run2_threadRunSyn {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread a = new MyThread(lock, "A", 1);
        MyThread b = new MyThread(lock, "B", 2);
        MyThread c = new MyThread(lock, "C", 0);
        a.start();
        b.start();
        c.start();
    }
}

/*
输出：
ThreadName=Thread-0 runCount = 1 A
ThreadName=Thread-1 runCount = 2 B
ThreadName=Thread-2 runCount = 3 C
ThreadName=Thread-0 runCount = 4 A
ThreadName=Thread-1 runCount = 5 B
ThreadName=Thread-2 runCount = 6 C
ThreadName=Thread-0 runCount = 7 A
ThreadName=Thread-1 runCount = 8 B
ThreadName=Thread-2 runCount = 9 C
 */