package com.brianway.learning.java.multithread.communication.example4;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * p152
 * wait(long)使用，时间限制内由其他线程唤醒
 */
public class Run4_waitHasParam2 {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer=" + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end timer=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2 = new Runnable() {
        public void run() {

            synchronized (lock) {
                System.out.println("notify begin timer=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end timer=" + System.currentTimeMillis());
            }

        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1);
        t1.start();
        Thread.sleep(2000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}


/*
输出：
wait begin timer=1460566507815
notify begin timer=1460566509815
notify end timer=1460566509815
wait end timer=1460566509815
 */