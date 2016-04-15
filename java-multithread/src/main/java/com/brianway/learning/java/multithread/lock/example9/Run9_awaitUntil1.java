package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P233
 * 测试方法awaitUntil()
 * 到达等待时间可唤醒自己
 */
public class Run9_awaitUntil1 {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
    }
}


/*
输出：
wait begin timer=1460724068711
wait end   timer=1460724078704
 */