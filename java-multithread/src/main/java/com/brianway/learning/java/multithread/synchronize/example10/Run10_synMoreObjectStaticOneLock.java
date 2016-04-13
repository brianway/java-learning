package com.brianway.learning.java.multithread.synchronize.example10;

/**
 * Created by brian on 2016/4/13.
 */

/**
 * P100
 * Class锁可以对类的所有对象实例起作用
 */
public class Run10_synMoreObjectStaticOneLock {
    public static void main(String[] args) {
        Service service1 = new Service();
        Service service2 = new Service();

        ThreadA a = new ThreadA(service1);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service2);
        b.setName("B");
        b.start();

    }
}

/*
输出：
线程名：A 在 1460479094611进入printA
线程名：A 在 1460479097611离开printA
线程名：B 在 1460479097611进入printB
线程名：B 在 1460479097611离开printB
 */
