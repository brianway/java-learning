package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P16小例子
 * myThread2.start()和myThread2.run()的区别
 */

class MyThread2 extends Thread {
    public MyThread2() {
        System.out.println("构造方法打印:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印：" + Thread.currentThread().getName());
    }
}

public class Run2_StartVsRun {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        //myThread2.run();
    }
}



/*
 myThread2.start();
//myThread2.run();
输出：
构造方法打印:main
run方法打印：Thread-0

--------------------
//myThread2.start();
myThread2.run();
输出：
构造方法打印:main
run方法打印：main

*/