package com.brianway.learning.java.multithread.synchronize.example10;

/**
 * Created by brian on 2016/4/13.
 */

/**
 * P101
 * 验证同步synchronized(class)代码块的作用
 * 顺便验证了下static方法是不能复写的
 *
 * @see ServiceSub,ServiceSub2
 */
public class Run10_synBlockMoreObjectOneLock {
    public static void main(String[] args) {
        //testSub();
        //testSub2();
        testBlock();
    }

    /**
     * 验证同步sychronized(class)代码块的作用
     */
    public static void testBlock() {
        final ServiceSub service1 = new ServiceSub();
        final ServiceSub service2 = new ServiceSub();

        Thread a = new Thread() {
            @Override
            public void run() {
                service1.printA();
            }
        };
        a.setName("A");
        a.start();
        Thread b = new Thread() {
            @Override
            public void run() {
                service2.printB();
            }
        };
        b.setName("B");
        b.start();
    }

    /**
     * testSub断点调试结果是运行的Service类的printA方法
     */
    public static void testSub() {
        ServiceSub service1 = new ServiceSub();
        ServiceSub service2 = new ServiceSub();

        ThreadA a = new ThreadA(service1);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service2);
        b.setName("B");
        b.start();
    }

    /**
     * testSub2断点调试结果是运行的Service类的printA方法
     */
    public static void testSub2() {
        ServiceSub2 service1 = new ServiceSub2();
        ServiceSub2 service2 = new ServiceSub2();

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
In ServiceSub
线程名：A 在 1460480421944进入printA
线程名：A 在 1460480423944离开printA
线程名：B 在 1460480423944进入printB
线程名：B 在 1460480423944离开printB

---------
也可能：
线程名：B 在 1460480476089进入printB
线程名：B 在 1460480476089离开printB
In ServiceSub
线程名：A 在 1460480476089进入printA
线程名：A 在 1460480478089离开printA

 */