package com.brianway.learning.java.multithread.timer.example1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P246
 * schedule(TimerTask task, Date time)测试，多个TimerTask任务及延时
 * 队列的方式，一个一个被顺序执行，前面一个耗时长则后面的任务被延后
 */
public class Run1_timer5 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("A计划时间为：" + runDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.SECOND, 5);
        Date runDate2 = calendar2.getTime();
        System.out.println("B计划时间为：" + runDate2);

        TaskA task1 = new TaskA();
        TaskB task2 = new TaskB();
        Timer timer = new Timer();
        timer.schedule(task1, runDate);
        timer.schedule(task2, runDate);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:39:30 CST 2016
A计划时间为：Fri Apr 15 22:39:30 CST 2016
B计划时间为：Fri Apr 15 22:39:35 CST 2016
A begin timer=Fri Apr 15 22:39:30 CST 2016
A end   timer=Fri Apr 15 22:39:40 CST 2016
B begin timer=Fri Apr 15 22:39:40 CST 2016
B end   timer=Fri Apr 15 22:39:40 CST 2016
 */