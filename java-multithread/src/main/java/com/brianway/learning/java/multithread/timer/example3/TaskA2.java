package com.brianway.learning.java.multithread.timer.example3;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Brian on 2016/4/15.
 */
public class TaskA2 extends TimerTask {
    @Override
    public void run() {
        System.out.println("A run timer=" + new Date());
    }
}
