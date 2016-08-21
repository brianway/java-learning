package com.brianway.learning.java.multithread.communication.example1;

/**
 * Created by Brian on 2016/4/13.
 */
public class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            list.add();
            System.out.println("添加了" + (i + 1) + "元素");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
