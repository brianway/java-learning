package com.brianway.learning.java.multithread.synchronize.example10;

/**
 * Created by brian on 2016/4/13.
 */
public class ServiceSub extends Service {

    public static void printA() {
        synchronized (ServiceSub.class) {
            try {
                System.out.println("In ServiceSub");
                System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printA");
                Thread.sleep(2000);
                System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printB() {
        synchronized (ServiceSub.class) {
            System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "进入printB");
            System.out.println("线程名：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "离开printB");
        }

    }

}
