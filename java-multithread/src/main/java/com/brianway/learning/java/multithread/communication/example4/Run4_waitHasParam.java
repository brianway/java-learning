package com.brianway.learning.java.multithread.communication.example4;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * p151
 * wait(long)使用，超时自动唤醒
 */
public class Run4_waitHasParam {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer=" + System.currentTimeMillis());
                    lock.wait(4000);
                    System.out.println("wait end timer=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        Thread t = new Thread(runnable1);
        t.start();
    }
}


/*
输出：
wait begin timer=1460566545742
wait end timer=1460566549743
 */