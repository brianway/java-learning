package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P253
 * schedule(TimerTask task, long delay, long period)方法
 */
public class Run4_schedule2 {
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
        timer.schedule(task, 2000, 1000);
    }
}

/*
输出：
当前时间：Sat Apr 16 00:01:34 CST 2016
运行了！时间为：Sat Apr 16 00:01:36 CST 2016
运行了！时间为：Sat Apr 16 00:01:37 CST 2016
运行了！时间为：Sat Apr 16 00:01:38 CST 2016
运行了！时间为：Sat Apr 16 00:01:39 CST 2016

 */