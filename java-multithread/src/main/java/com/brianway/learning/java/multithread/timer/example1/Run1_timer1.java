package com.brianway.learning.java.multithread.timer.example1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P242
 * schedule(TimerTask task, Date time)测试，在未来执行的效果
 * Timer的构造方法会新启一个线程，且非守护线程
 */
public class Run1_timer1 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date runDate = calendar.getTime();

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, runDate);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:10:14 CST 2016
任务执行了，时间为：Fri Apr 15 22:10:19 CST 2016
 */