package com.brianway.learning.java.multithread.timer.example1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P245
 * schedule(TimerTask task, Date time)测试，多个TimerTask任务及延时
 */
public class Run1_timer4 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate2 = calendar2.getTime();
        System.out.println("计划时间为：" + runDate2);

        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task1, runDate);
        timer.schedule(task2, runDate);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:24:08 CST 2016
计划时间为：Fri Apr 15 22:24:13 CST 2016
计划时间为：Fri Apr 15 22:24:08 CST 2016
任务执行了，时间为：Fri Apr 15 22:24:13 CST 2016
任务执行了，时间为：Fri Apr 15 22:24:13 CST 2016
 */