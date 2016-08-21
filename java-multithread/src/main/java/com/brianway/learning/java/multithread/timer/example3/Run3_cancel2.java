package com.brianway.learning.java.multithread.timer.example3;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P250
 * Timer类的cancel()方法
 * 全部任务被清除，且进程被销毁
 */
public class Run3_cancel2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        TaskA2 task1 = new TaskA2();
        TaskB2 task2 = new TaskB2();
        Timer timer = new Timer();
        timer.schedule(task1, runDate, 2000);
        timer.schedule(task2, runDate, 2000);
        Thread.sleep(10000);
        timer.cancel();
    }
}

/*
输出：
当前时间为：Fri Apr 15 23:49:29 CST 2016
计划时间为：Fri Apr 15 23:49:29 CST 2016
A run timer=Fri Apr 15 23:49:29 CST 2016
B run timer=Fri Apr 15 23:49:29 CST 2016
A run timer=Fri Apr 15 23:49:31 CST 2016
B run timer=Fri Apr 15 23:49:31 CST 2016
A run timer=Fri Apr 15 23:49:33 CST 2016
B run timer=Fri Apr 15 23:49:33 CST 2016
B run timer=Fri Apr 15 23:49:35 CST 2016
A run timer=Fri Apr 15 23:49:35 CST 2016
A run timer=Fri Apr 15 23:49:37 CST 2016
B run timer=Fri Apr 15 23:49:37 CST 2016

 */