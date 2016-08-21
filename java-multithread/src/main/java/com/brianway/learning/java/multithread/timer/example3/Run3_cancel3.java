package com.brianway.learning.java.multithread.timer.example3;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P252
 * Timer类的cancel()方法
 * 有时不一定会停止计划任务,（见源码，queue锁）
 */
public class Run3_cancel3 {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();

        while (true) {
            i++;
            Timer timer = new Timer();
            MyTask task = new MyTask(i);
            timer.schedule(task, runDate);
            timer.cancel();
        }

    }
}

/*
输出：
第1次没有被cancel取消
第44674次没有被cancel取消
第44676次没有被cancel取消
第44678次没有被cancel取消
第44682次没有被cancel取消
第44684次没有被cancel取消
第44686次没有被cancel取消
第44688次没有被cancel取消
第44697次没有被cancel取消
第44702次没有被cancel取消
第44706次没有被cancel取消
第67967次没有被cancel取消
 */