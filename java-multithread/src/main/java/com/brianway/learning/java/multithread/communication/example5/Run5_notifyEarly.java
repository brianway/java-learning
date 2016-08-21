package com.brianway.learning.java.multithread.communication.example5;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * P154
 * notify通知过早
 */
public class Run5_notifyEarly {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        Thread b = new Thread(myRun.runnableNotify);
        b.start();
        Thread.sleep(100);
        Thread a = new Thread(myRun.runnableWait);
        a.start();
    }

}

/*
输出：
notify begin timer=1460567514794
notify end timer=1460567514794
 */