package com.brianway.learning.java.multithread.timer.example3;

import java.util.TimerTask;

/**
 * Created by brian on 2016/4/15.
 */
public class MyTask extends TimerTask {
    private int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第" + i + "次没有被cancel取消");
    }
}
