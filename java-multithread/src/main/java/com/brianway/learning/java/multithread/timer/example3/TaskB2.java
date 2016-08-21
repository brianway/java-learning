package com.brianway.learning.java.multithread.timer.example3;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Brian on 2016/4/15.
 */
public class TaskB2 extends TimerTask {
    @Override
    public void run() {
        System.out.println("B run timer=" + new Date());
    }
}
