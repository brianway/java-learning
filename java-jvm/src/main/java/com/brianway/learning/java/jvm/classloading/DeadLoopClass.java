package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/20.
 * 字段解析
 * 多个线程同时初始化一个类,只有一个线程会执行 <clinit>()方法,其他被阻塞
 */
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + " start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
