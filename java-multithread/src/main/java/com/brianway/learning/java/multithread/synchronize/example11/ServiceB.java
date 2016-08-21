package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */
public class ServiceB {
    public static void print(Object object) {
        try {
            synchronized (object) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
