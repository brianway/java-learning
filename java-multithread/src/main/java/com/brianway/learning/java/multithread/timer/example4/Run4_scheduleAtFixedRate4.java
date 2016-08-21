package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * P259
 * scheduleAtFixedRate(TimerTask task, long delay, long period)方法
 * long类型
 * 在延时的情况下，若执行任务被延时，下次执行任务的开始时间是上一次任务的开始时间作为参考点
 */
public class Run4_scheduleAtFixedRate4 {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end   timer=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("当前时间：" + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 3000, 2000);
    }
}

/*
输出：
当前时间：1460738720674
begin timer=1460738723676
end   timer=1460738728676
begin timer=1460738728676
end   timer=1460738733676
begin timer=1460738733676

 */