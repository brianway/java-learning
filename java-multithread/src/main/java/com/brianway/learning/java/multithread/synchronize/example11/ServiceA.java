package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */
public class ServiceA {
    public static void print(String stringParam) {
        try {
            synchronized (stringParam) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
