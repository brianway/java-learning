package com.brianway.learning.java.multithread.synchronize.example8;

/**
 * Created by Brian on 2016/4/12.
 */
public class MyThreadA extends Thread {
    private TaskA taskA;

    public MyThreadA(TaskA taskA) {
        super();
        this.taskA = taskA;
    }

    @Override
    public void run() {
        super.run();
        if (this.getName().equals("a")) {
            CommonUtils.beginTime1 = System.currentTimeMillis();
            taskA.doLongTimeTask();
            CommonUtils.endTime1 = System.currentTimeMillis();
        } else if (this.getName().equals("b")) {
            CommonUtils.beginTime2 = System.currentTimeMillis();
            taskA.doLongTimeTask();
            CommonUtils.endTime2 = System.currentTimeMillis();
        } else {
            System.out.println("unexpected name");
        }

    }
}
