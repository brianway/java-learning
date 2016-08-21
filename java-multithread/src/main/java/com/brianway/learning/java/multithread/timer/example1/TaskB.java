package com.brianway.learning.java.multithread.timer.example1;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Brian on 2016/4/15.
 */
public class TaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B begin timer=" + new Date());
        System.out.println("B end   timer=" + new Date());
    }
}
