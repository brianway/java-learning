package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * 取消System.out.println的注释能看到更多细节
 */
public class MyThread extends Thread {
    private Object lock;
    private String showChar;
    private int showNumPosition;
    private int printCount = 0;//统计打印了几个字母
    volatile private static int addNumber = 1;

    public MyThread(Object lock, String showChar, int showNumPosition) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                //System.out.println("ThreadName="+ Thread.currentThread().getName()+" get the lock");
                while (true) {
                    if (addNumber % 3 == showNumPosition) {
                        System.out.println("ThreadName=" + Thread.currentThread().getName()
                                + " runCount = " + addNumber + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 3) {
                            break;
                        }
                    } else {
                        //System.out.println("ThreadName="+ Thread.currentThread().getName()+" will await");
                        lock.wait();
                        //System.out.println("ThreadName="+ Thread.currentThread().getName()+" after await");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
