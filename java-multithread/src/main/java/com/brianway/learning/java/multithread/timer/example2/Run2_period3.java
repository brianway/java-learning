package com.brianway.learning.java.multithread.timer.example2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P248
 * schedule(TimerTask task, long delay, long period) 测试，任务执行时间被延时
 */
public class Run2_period3 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        TaskA task = new TaskA();
        Timer timer = new Timer();
        timer.schedule(task, runDate, 3000);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:44:47 CST 2016
计划时间为：Fri Apr 15 22:44:57 CST 2016
A begin timer=Fri Apr 15 22:44:57 CST 2016
A end   timer=Fri Apr 15 22:45:02 CST 2016
A begin timer=Fri Apr 15 22:45:02 CST 2016
A end   timer=Fri Apr 15 22:45:07 CST 2016
A begin timer=Fri Apr 15 22:45:07 CST 2016
A end   timer=Fri Apr 15 22:45:12 CST 2016
A begin timer=Fri Apr 15 22:45:12 CST 2016

(一直执行，后面省略)
 */