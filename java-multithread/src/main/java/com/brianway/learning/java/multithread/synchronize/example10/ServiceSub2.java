package com.brianway.learning.java.multithread.synchronize.example10;

/**
 * Created by brian on 2016/4/13.
 */
public class ServiceSub2 extends Service {
    synchronized public static void printA() {
        try {
            System.out.println("ServiceSub2");
            System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printA");
            Thread.sleep(1000);
            System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printB");
    }
}
