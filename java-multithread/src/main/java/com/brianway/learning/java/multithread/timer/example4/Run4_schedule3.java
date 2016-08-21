package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P254
 * schedule(TimerTask task, Date firstTime, long period) 方法
 * Date类型
 * 不延时的情况下，若执行任务未被延时，下次执行任务的开始时间是上一次任务的开始时间加上period
 */
public class Run4_schedule3 {
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
        timer.schedule(task, runDate, 3000);
    }
}

/*
输出：
begin timer=1460736286532
end   timer=1460736287533
begin timer=1460736289532
end   timer=1460736290532
begin timer=1460736292536
end   timer=1460736293536
begin timer=1460736295536
end   timer=1460736296536
begin timer=1460736298536
end   timer=1460736299536
begin timer=1460736301536
end   timer=1460736302536


 */