package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P232
 * 测试方法awaitUniterruptibly()
 */
public class Run9_awaitUniterruptibly2 {
    public static void main(String[] args) {
        try {
            Service2 service = new Service2();
            Thread2 thread = new Thread2(service);
            thread.start();
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
wait begin

 */