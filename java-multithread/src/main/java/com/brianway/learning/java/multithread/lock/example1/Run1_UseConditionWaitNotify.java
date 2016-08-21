package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */

/**
 * P206
 * 使用Condition实现等待通知
 * Condition对象的await()方法，线程WAITING
 */
public class Run1_UseConditionWaitNotify {
    public static void main(String[] args) {
        ServiceB service = new ServiceB();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}


/*
输出：
A
 */