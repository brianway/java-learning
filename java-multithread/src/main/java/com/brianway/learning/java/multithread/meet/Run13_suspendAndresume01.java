package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P36例子
 * 暂停线程
 * suspend与resume
 */
class MyThread13 extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}

public class Run13_suspendAndresume01 {
    public static void main(String[] args) {
        try {
            MyThread13 myThread13 = new MyThread13();
            myThread13.start();
            Thread.sleep(5000);
            //A段
            myThread13.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread13.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread13.getI());

            //B段
            myThread13.resume();
            Thread.sleep(5000);
            //C段
            myThread13.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread13.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i=" + myThread13.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出：
A= 1460358676950 i=2813771327
A= 1460358681950 i=2813771327
B= 1460358686951 i=5617784671
B= 1460358691951 i=5617784671
end
 */