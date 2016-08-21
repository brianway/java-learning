package com.brianway.learning.java.multithread.synchronize.example5;

/**
 * Created by Brian on 2016/4/12.
 */
public class Sub extends Main {
    synchronized public void operateIinSub() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIinMain();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
