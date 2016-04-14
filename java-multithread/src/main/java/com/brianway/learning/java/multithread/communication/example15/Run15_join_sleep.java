package com.brianway.learning.java.multithread.communication.example15;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P185
 * join(long)和sleep(long)的区别
 * sleep(long)方法不释放锁
 */
public class Run15_join_sleep {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
b run begin timer=1460637031625
b run end timer=1460637036626
打印了bService timer=1460637037626



 */