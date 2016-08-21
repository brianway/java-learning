package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */
public class Thread2 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("begin sleep,run方法中的状态：" + this.getState() + " of " + this.getName());
            System.out.println("begin sleep,run方法中的状态：" + Thread.currentThread().getState() + " of " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("end sleep,run方法中的状态：" + this.getState() + " of " + this.getName());
            System.out.println("end sleep,run方法中的状态：" + Thread.currentThread().getState() + " of " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
