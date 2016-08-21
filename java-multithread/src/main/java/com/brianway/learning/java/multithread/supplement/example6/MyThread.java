package com.brianway.learning.java.multithread.supplement.example6;

/**
 * Created by Brian on 2016/4/17.
 */
public class MyThread extends Thread {
    private String num = "a";

    public MyThread() {
    }

    public MyThread(MyThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        System.out.println("在线程中打印：" + (numInt + 1));
    }
}
