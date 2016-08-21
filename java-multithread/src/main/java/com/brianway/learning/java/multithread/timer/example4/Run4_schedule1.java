package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P252
 * schedule(TimerTask task, long delay)方法
 */
public class Run4_schedule1 {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Timer timer = new Timer();
        System.out.println("当前时间：" + new Date());
        timer.schedule(task, 7000);
    }
}

/*
输出：
当前时间：Sat Apr 16 00:00:22 CST 2016
运行了！时间为：Sat Apr 16 00:00:29 CST 2016

 */