package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P233
 * 测试方法awaitUntil()
 * 线程在等待时间到达前，可以被其他线程唤醒
 */
public class Run9_awaitUntil2 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        Thread.sleep(2000);
        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}


/*
输出：
wait begin timer=1460724153513
notify begin timer=1460724155507
notify end   timer=1460724155507
wait end   timer=1460724155508
 */