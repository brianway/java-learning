package com.brianway.learning.java.multithread.communication.example16;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadB线程中取值=" + Tools.itl.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
