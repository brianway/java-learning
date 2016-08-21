package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P102
 * String作为锁对象
 * 常量池->同一锁
 */
public class Run11_StringAndSyn {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA();
        ThreadA a = new ThreadA(serviceA);
        a.setName("A");
        a.start();
        ThreadA b = new ThreadA(serviceA);
        b.setName("B");
        b.start();
    }
}


/*
输出：
A
A
A
A
A
A
A
A

 */