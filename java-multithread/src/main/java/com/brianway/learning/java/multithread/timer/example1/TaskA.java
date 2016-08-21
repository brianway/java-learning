package com.brianway.learning.java.multithread.timer.example1;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Brian on 2016/4/15.
 */
public class TaskA extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("A begin timer=" + new Date());
            Thread.sleep(10000);
            System.out.println("A end   timer=" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
