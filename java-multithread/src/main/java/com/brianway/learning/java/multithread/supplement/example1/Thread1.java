package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */
public class Thread1 extends Thread {
    public Thread1() {
        System.out.println("构造方法中的状态：" + this.getState() + " of " + this.getName());
        System.out.println("构造方法中的状态：" + Thread.currentThread().getState() + " of " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中的状态：" + this.getState() + " of " + this.getName());
        System.out.println("run方法中的状态：" + Thread.currentThread().getState() + " of " + Thread.currentThread().getName());
    }
}
