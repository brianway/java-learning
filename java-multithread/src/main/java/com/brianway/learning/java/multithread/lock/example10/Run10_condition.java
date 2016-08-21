package com.brianway.learning.java.multithread.lock.example10;

/**
 * Created by Brian on 2016/4/15.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * P234
 * Condition实现顺序打印
 * 这里nextPrintWho的volatile关键词去掉也没什么影响
 */
public class Run10_condition {
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 1) {
                        conditionA.await();
                    }

                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadA " + (i + 1));
                    }
                    nextPrintWho = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 2) {
                        conditionB.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadB " + (i + 1));
                    }
                    nextPrintWho = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread c = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        conditionC.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("ThreadC " + (i + 1));
                    }
                    nextPrintWho = 1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(a);
            bArray[i] = new Thread(b);
            cArray[i] = new Thread(c);

            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }

    }
}

/*
输出：
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3

 */