package com.brianway.learning.java.multithread.synchronize.example15;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P130
 * synchronized代码块有volatile同步的功能
 */
public class Run15_synchronized {
    public static void main(String[] args) {
        try {
            RunThread2 t = new RunThread2();
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
线程被停止了
已经赋值为false

-----------------
注释掉RunThread2类中的synchronized ("any thing"){}
输出：
进入run了
已经赋值为false

 */