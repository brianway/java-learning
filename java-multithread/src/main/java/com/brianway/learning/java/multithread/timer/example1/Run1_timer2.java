package com.brianway.learning.java.multithread.timer.example1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P243
 * schedule(TimerTask task, Date time)测试，在未来执行的效果
 * Timer的构造方法会新启一个守护线程
 * 迅速结束，task任务未被执行
 */
public class Run1_timer2 {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date runDate = calendar.getTime();

        MyTask task = new MyTask();
        Timer timer = new Timer(true);//守护线程
        timer.schedule(task, runDate);
    }
}

/*
输出：
当前时间为：Fri Apr 15 22:12:28 CST 2016
 */