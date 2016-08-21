package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P42例子
 * 测试yield
 */

class MyThread16 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时:" + (endTime - beginTime) + "毫秒");
    }
}

public class Run16_yield {
    public static void main(String[] args) {
        MyThread16 myThread16 = new MyThread16();
        myThread16.start();
    }
}


/*
//Thread.yield();
输出:
用时:2毫秒

-----------------

Thread.yield();
输出:
用时:3302毫秒

 */