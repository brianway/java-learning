package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P38例子
 * suspend与resume的缺点：独占
 */

class SynchronizedObject {
    synchronized public void printString() {
        System.out.println("begin printString");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end printString");
    }
}

public class Run14_suspendAndresume02 {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2启动了，但进不了printString()方法！只打印一个begin");
                    System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
begin printString
a线程永远suspend了！
thread2启动了，但进不了printString()方法！只打印一个begin
因为printString()方法被a线程锁定并且永远suspend暂停了！
 */