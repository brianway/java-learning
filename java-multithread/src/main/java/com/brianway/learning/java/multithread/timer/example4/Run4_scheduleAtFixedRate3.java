package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P258
 * scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 方法
 * Date类型
 * 在延时的情况下，若执行任务被延时，下次执行任务的开始时间是上一次任务的开始时间作为参考点
 */
public class Run4_scheduleAtFixedRate3 {
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
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, runDate, 2000);
    }
}

/*
输出：
begin timer=1460738658244
end   timer=1460738663246
begin timer=1460738663246
end   timer=1460738668247
begin timer=1460738668247
end   timer=1460738673247
begin timer=1460738673247


 */