package com.brianway.learning.java.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P260
 * schedule不具有追赶执行性
 */
public class Run4_schedule_vs_scheduleAtFixedRate_1 {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("begin timer=" + new Date());
            System.out.println("end   timer=" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("现在执行时间：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
        Date runDate = calendar.getTime();
        System.out.println("计划执行时间：" + runDate);
        Timer timer = new Timer();
        timer.schedule(task, runDate, 2000);
    }
}

/*
输出：
现在执行时间：Sat Apr 16 00:51:36 CST 2016
计划执行时间：Sat Apr 16 00:51:16 CST 2016
begin timer=Sat Apr 16 00:51:36 CST 2016
end   timer=Sat Apr 16 00:51:36 CST 2016
begin timer=Sat Apr 16 00:51:38 CST 2016
end   timer=Sat Apr 16 00:51:38 CST 2016
begin timer=Sat Apr 16 00:51:40 CST 2016
end   timer=Sat Apr 16 00:51:40 CST 2016
begin timer=Sat Apr 16 00:51:42 CST 2016
end   timer=Sat Apr 16 00:51:42 CST 2016

 */