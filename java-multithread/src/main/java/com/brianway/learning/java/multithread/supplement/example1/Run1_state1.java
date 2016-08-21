package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P280
 * 验证NEW,RUNNABLE,TERMINATED
 */
public class Run1_state1 {
    public static void main(String[] args) {
        try {
            Thread1 t = new Thread1();
            System.out.println("main方法中的状态1：" + t.getState() + " of " + t.getName());
            Thread.sleep(1000);
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态2：" + t.getState() + " of " + t.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
输出：
构造方法中的状态：NEW of Thread-0
构造方法中的状态：RUNNABLE of main
main方法中的状态1：NEW of Thread-0
run方法中的状态：RUNNABLE of Thread-0
run方法中的状态：RUNNABLE of Thread-0
main方法中的状态2：TERMINATED of Thread-0
 */