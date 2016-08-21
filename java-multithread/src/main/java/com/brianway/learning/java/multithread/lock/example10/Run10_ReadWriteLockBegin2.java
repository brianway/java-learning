package com.brianway.learning.java.multithread.lock.example10;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P238
 * 类ReentrantReadWriteLock的使用：写写互斥
 */
public class Run10_ReadWriteLockBegin2 {
    public static void main(String[] args) {
        final Service2 service = new Service2();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.write();
            }
        };
        Thread b = new Thread() {
            @Override
            public void run() {
                service.write();
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
获得写锁A 1460727106721
获得写锁B 1460727116721
 */