package com.brianway.learning.java.multithread.communication.example14;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P183
 * join(long)设定等待的时间
 * join(long)和sleep(long)运行效果并无区别，但对同步的处理不同。
 */
public class Run14_joinLong {
    public static void main(String[] args) {
        try {
            Run14_Thread thread = new Run14_Thread();
            thread.start();
            thread.join(2000);//只等2秒
            //Thread.sleep(2000);
            System.out.println("end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Run14_Thread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
输出：
begin timer=1460635411651
end timer=1460635413651
 */