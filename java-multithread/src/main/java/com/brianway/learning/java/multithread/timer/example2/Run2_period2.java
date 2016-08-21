package com.brianway.learning.java.multithread.timer.example2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P247
 * schedule(TimerTask task, long delay, long period) 测试，提前运行的效果
 */
public class Run2_period2 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 10);
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, runDate, 4000);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:42:32 CST 2016
计划时间为：Fri Apr 15 22:42:22 CST 2016
任务执行了，时间为：Fri Apr 15 22:42:32 CST 2016
任务执行了，时间为：Fri Apr 15 22:42:36 CST 2016
任务执行了，时间为：Fri Apr 15 22:42:40 CST 2016
任务执行了，时间为：Fri Apr 15 22:42:44 CST 2016

(一直执行，后面省略)
 */