package com.brianway.learning.java.multithread.lock.example10;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P238
 * 类ReentrantReadWriteLock的使用：读写互斥
 */
public class Run10_ReadWriteLockBegin3 {
    public static void main(String[] args) {
        final Service3 service = new Service3();
        Thread a = new Thread() {
            @Override
            public void run() {
                service.read();
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
获得读锁 A 1460727280066
获得写锁 B 1460727290067
 */