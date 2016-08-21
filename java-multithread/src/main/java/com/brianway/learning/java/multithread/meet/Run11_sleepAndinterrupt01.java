package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P30
 * 睡眠中停止，先进入的sleep,再interrupt()
 */
class MyThread11 extends Thread {
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("沉睡中被停止！进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

public class Run11_sleepAndinterrupt01 {
    public static void main(String[] args) {
        try {
            MyThread11 myThread11 = new MyThread11();
            myThread11.start();
            Thread.sleep(200);
            myThread11.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出：
run begin
沉睡中被停止！进入catch!false
end
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.brianway.learning.java.multithread.meet.MyThread11.run(Run11_sleepAndinterrupt01.java:18)

-------
输出不唯一：
run begin
end
沉睡中被停止！进入catch!false
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.brianway.learning.java.multithread.meet.MyThread11.run(Run11_sleepAndinterrupt01.java:18)

*/