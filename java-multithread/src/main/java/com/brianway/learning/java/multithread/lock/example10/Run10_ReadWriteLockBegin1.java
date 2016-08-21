package com.brianway.learning.java.multithread.lock.example10;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P236
 * 类ReentrantReadWriteLock的使用：读读共享
 */
public class Run10_ReadWriteLockBegin1 {
    public static void main(String[] args) {
        final Service1 service = new Service1();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.read();
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                service.read();
            }
        };
        a.setName("A");
        a.start();
        b.setName("B");
        b.start();
    }
}


/*
输出：
获得读锁A 1460726504907
获得读锁B 1460726504908
 */