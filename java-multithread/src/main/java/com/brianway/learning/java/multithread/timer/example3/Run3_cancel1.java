package com.brianway.learning.java.multithread.timer.example3;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P249
 * TimerTask类的cancel()方法
 * 将自身从任务队列移除，其他任务不受影响
 */
public class Run3_cancel1 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        TaskA task1 = new TaskA();
        TaskB task2 = new TaskB();
        Timer timer = new Timer();
        timer.schedule(task1, runDate, 4000);
        timer.schedule(task2, runDate, 4000);

    }
}

/*
输出：
当前时间为：Fri Apr 15 23:41:22 CST 2016
计划时间为：Fri Apr 15 23:41:22 CST 2016
A run timer=Fri Apr 15 23:41:22 CST 2016
A任务自己移除自己
B run timer=Fri Apr 15 23:41:22 CST 2016
B run timer=Fri Apr 15 23:41:26 CST 2016
B run timer=Fri Apr 15 23:41:30 CST 2016


(一直执行，后面省略)
 */