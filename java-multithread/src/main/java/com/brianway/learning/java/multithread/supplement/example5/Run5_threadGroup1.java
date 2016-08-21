package com.brianway.learning.java.multithread.supplement.example5;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * p299
 * 线程组内处理异常
 */
public class Run5_threadGroup1 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Brian's group");
        Thread1[] threads = new Thread1[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread1(group, "线程" + (i + 1), "1");
            threads[i].start();
        }
        Thread1 newT = new Thread1(group, "线程报错", "a");
        newT.start();
    }
}

/*
一个线程异常不会停止组内其他线程
 */