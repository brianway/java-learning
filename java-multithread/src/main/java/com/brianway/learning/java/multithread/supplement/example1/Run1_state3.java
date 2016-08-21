package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P283
 * 验证BLOCKED
 */
public class Run1_state3 {
    public static void main(String[] args) {
        try {
            Thread3 t1 = new Thread3();
            t1.setName("a");
            t1.start();
            Thread3 t2 = new Thread3();
            t2.setName("b");
            t2.start();
            Thread.sleep(1000);
            System.out.println("main方法中的t2状态：" + t2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


/*
输出：
a 进入了业务方法
main方法中的t2状态：BLOCKED
b 进入了业务方法
 */