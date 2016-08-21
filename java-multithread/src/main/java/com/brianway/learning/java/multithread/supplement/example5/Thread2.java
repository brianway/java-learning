package com.brianway.learning.java.multithread.supplement.example5;

/**
 * Created by Brian on 2016/4/17.
 */
public class Thread2 extends Thread {
    private String num;

    public Thread2(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted() == false) {
            System.out.println("死循环中：" + Thread.currentThread().getName());
        }
    }
}
