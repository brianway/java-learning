package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P286
 * 线程对象关联线程组，一级关联
 */
public class Run2_groupAddThread {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadGroup group = new ThreadGroup("Brian's group");
        Thread athread = new Thread(group, a);
        Thread bthread = new Thread(group, b);
        athread.start();
        bthread.start();
        System.out.println("活动的线程数为：" + group.activeCount());
        System.out.println("线程组的名称为：" + group.getName());
    }
}

/*
输出：
活动的线程数为：2
ThreadName = Thread-3
ThreadName = Thread-2
线程组的名称为：Brian's group
ThreadName = Thread-2
ThreadName = Thread-3
ThreadName = Thread-2
ThreadName = Thread-3
 */