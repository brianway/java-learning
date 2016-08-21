package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P43例子
 * 线程优先级的继承性
 */

class MyThread17_1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread17_1 run priority=" + this.getPriority());
        MyThread17_2 myThread17_2 = new MyThread17_2();
        myThread17_2.start();

    }
}

class MyThread17_2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread17_2 run priority=" + this.getPriority());
    }
}

public class Run17_priority01 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority =" + Thread.currentThread().getPriority());
        //Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority =" + Thread.currentThread().getPriority());
        MyThread17_1 myThread17_1 = new MyThread17_1();
        myThread17_1.start();
    }
}

/*
//Thread.currentThread().setPriority(6);
输出：
main thread begin priority =5
main thread end priority =5
MyThread17_1 run priority=5
MyThread17_2 run priority=5

--------------------

Thread.currentThread().setPriority(6);
输出：
main thread begin priority =5
main thread end priority =6
MyThread17_1 run priority=6
MyThread17_2 run priority=6

 */
