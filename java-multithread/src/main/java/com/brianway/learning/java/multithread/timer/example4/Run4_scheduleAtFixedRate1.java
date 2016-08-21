package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P257
 * scheduleAtFixedRate(TimerTask task, Date firstTime,long period)方法
 * Date类型
 * 不延时的情况下，若执行任务未被延时，下次执行任务的开始时间是上一次任务的开始时间加上period
 */
public class Run4_scheduleAtFixedRate1 {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(1000);
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
        timer.scheduleAtFixedRate(task, runDate, 3000);
    }
}

/*
输出：
begin timer=1460738424663
end   timer=1460738425663
begin timer=1460738427636
end   timer=1460738428636
begin timer=1460738430635
end   timer=1460738431635


 */