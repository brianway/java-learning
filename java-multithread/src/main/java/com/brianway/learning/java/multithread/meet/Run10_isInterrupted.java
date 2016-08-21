package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P26例子
 * isInterrupted()，不清除状态标记
 */

public class Run10_isInterrupted {
    public static void main(String[] args) {
        try {
            MyThread7 myThread7 = new MyThread7();
            myThread7.start();
            Thread.sleep(100);
            myThread7.interrupt();
            System.out.println("Thread.interrupted()，是否停止1？=" + myThread7.isInterrupted());
            System.out.println("Thread.interrupted()，是否停止2？=" + myThread7.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/*
输出节选：
i=17596
i=17597
i=17598
i=17599
Thread.interrupted()，是否停止1？=true
Thread.interrupted()，是否停止2？=true
end
i=17600
i=17601
i=17602
 */