package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/10.
 */

/**
 * P11数据共享的例子
 */

class MyThread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "  计算,count=" + count);
    }
}

public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        a.start();
        b.start();
        c.start();
        d.start();
    }
}


/*
output(某一次):
由A  计算,count=3
由C  计算,count=2
由B  计算,count=3
由D  计算,count=1

output(某一次):
由A  计算,count=4
由C  计算,count=3
由D  计算,count=1
由B  计算,count=1
 */