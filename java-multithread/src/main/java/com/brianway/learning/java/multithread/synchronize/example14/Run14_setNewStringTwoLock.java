package com.brianway.learning.java.multithread.synchronize.example14;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P114
 * 锁对象改变
 */
public class Run14_setNewStringTwoLock {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        a.setName("A");
        Thread b = new Thread() {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        b.setName("B");

        a.start();
        Thread.sleep(50);
        b.start();

    }
}


/*
输出：
A begin 1460536381652
B begin 1460536381702
A end 1460536383652
B end 1460536383702


--------------

//Thread.sleep(50);
输出：
A begin 1460536503287
A end 1460536505287
B begin 1460536505287
B end 1460536507287
 */