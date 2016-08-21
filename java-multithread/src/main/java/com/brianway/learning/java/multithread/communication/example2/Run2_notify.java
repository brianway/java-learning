package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P139
 * notify实现通知
 * notify调用后，并不会立即释放对象锁，而是退出synchronized代码块后
 *
 * 当在一个Synchronized块中调用Sleep()方法是，线程虽然休眠了，但是对象的机锁并木有被释放，其他线程无法访问这个对象
 *
 * @see Thread2 的run方法
 */
public class Run2_notify {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            Thread1 t1 = new Thread1(lock);
            t1.start();
            Thread.sleep(3000);
            Thread2 t2 = new Thread2(lock);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


/*
输出：
开始 wait   time=1460554213416
开始 notify time=1460554216418
结束 notify time=1460554218418
结束 wait   time=1460554218418

 */