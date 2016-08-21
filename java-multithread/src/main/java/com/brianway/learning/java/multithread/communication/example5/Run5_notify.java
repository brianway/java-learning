package com.brianway.learning.java.multithread.communication.example5;

/**
 * Created by brian on 2016/4/14.
 */

/**
 * P154
 * notify正常通知
 */
public class Run5_notify {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        Thread a = new Thread(myRun.runnableWait);
        a.start();
        Thread.sleep(100);
        Thread b = new Thread(myRun.runnableNotify);
        b.start();
    }

}

/*
输出：
wait begin timer=1460567668037
notify begin timer=1460567668137
notify end timer=1460567668137
wait end timer=1460567668137
 */