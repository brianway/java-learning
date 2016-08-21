package com.brianway.learning.java.multithread.communication.example14;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P180
 * join示例,阻塞当前线程z，使join所属的线程对象x正常执行run()方法,执行完在继续当前线程z后面的代码
 */
public class Run14_join {
    public static void main(String[] args) {
        try {
            Run14_Thread t = new Run14_Thread();
            t.start();
            t.join();
            System.out.println("thread执行完后在会打印这句话");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Run14_Thread extends Thread {
        @Override
        public void run() {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
输出：
6690
thread执行完后在会打印这句话
 */