package com.brianway.learning.java.multithread.synchronize.example15;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P121
 * 不使用volatile关键字
 * JVM配置 -server(IDEA15.02，jdk1.8,WIN7,64bit不加效果也是的)
 */
public class Run15_volatile {
    public static void main(String[] args) {
        try {
            RunThread t = new RunThread();
            t.start();
            Thread.sleep(1000);
            t.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
输出：
进入run了
已经赋值为false

--------------
加上volatile关键字后
输出：
进入run了
已经赋值为false
线程被停止了
 */