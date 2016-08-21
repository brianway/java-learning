package com.brianway.learning.java.multithread.communication.example15;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P187
 * join(long)和sleep(long)的区别
 * join(long)释放锁
 */
public class Run15_join_sleep_2 {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA2 a = new ThreadA2(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA2 extends Thread {
        private ThreadB b;

        public ThreadA2(ThreadB b) {
            super();
            this.b = b;
        }

        @Override
        public void run() {
            try {
                synchronized (b) {
                    b.start();
                    b.join();
                    System.out.println("a run before for " + System.currentTimeMillis());
                    for (int i = 0; i < 100000000; i++) {
                        Math.random();
                    }
                    System.out.println("a run end " + System.currentTimeMillis());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
输出：
b run begin timer=1460637677744
打印了bService timer=1460637678746
b run end timer=1460637682745
a run before for 1460637682745
a run end 1460637684923
 */