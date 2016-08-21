package com.brianway.learning.java.multithread.synchronize.example10;

/**
 * Created by brian on 2016/4/13.
 */

/**
 * P97
 * 验证synchronized关键字加载static静态方法和加到非静态方法不是同一个锁
 * 一个是Class类上锁，一个是对象上锁
 */
public class Run10_synTwoLock {
    public static void main(String[] args) {
        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadC c = new ThreadC(service);
        c.setName("C");
        c.start();
    }
}

/*
输出：
线程名：A 在 1460478479803进入printA
线程名：C 在 1460478479808进入printC
线程名：C 在 1460478479808离开printC
线程名：A 在 1460478482804离开printA
线程名：B 在 1460478482804进入printB
线程名：B 在 1460478482804离开printB
 */