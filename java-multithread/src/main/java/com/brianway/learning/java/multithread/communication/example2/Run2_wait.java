package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P137
 * wait()永远阻塞
 */
public class Run2_wait {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("syn上面");
            synchronized (lock) {
                System.out.println("syn第一行,wait前面");
                lock.wait();
                System.out.println("wait下面的代码");
            }
            System.out.println("syn下面的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
syn上面
syn第一行,wait前面
 */