package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P142
 * 测试sleep()期间其他线程是否执行
 * 处理器资源，对象锁，是不同的概念
 */
public class Run2_sleep {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(Thread.currentThread().getName() + " begin sleep");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end sleep");
            }
        };
        t1.setName("t1");

        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                long i = 0;
                long max = (long) Integer.MAX_VALUE;
                System.out.println("max = " + max);

                System.out.println(Thread.currentThread().getName() + " begin while");
                while (i < max) {
                    i++;
                    if (i % 100000000 == 0) {
                        System.out.println(Thread.currentThread().getName() + " now is " + i);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " end while");
            }
        };
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}

/*
输出：
t1 begin sleep
max = 2147483647
t2 begin while
t2 now is 100000000
t2 now is 200000000
t2 now is 300000000
t2 now is 400000000
t2 now is 500000000
t2 now is 600000000
t2 now is 700000000
t2 now is 800000000
t2 now is 900000000
t2 now is 1000000000
t2 now is 1100000000
t2 now is 1200000000
t2 now is 1300000000
t2 now is 1400000000
t2 now is 1500000000
t1 end sleep
t2 now is 1600000000
t2 now is 1700000000
t2 now is 1800000000
t2 now is 1900000000
t2 now is 2000000000
t2 now is 2100000000
t2 end while
 */
