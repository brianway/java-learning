package com.brianway.learning.java.multithread.synchronize.example11;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P104
 * 不使用String作为锁对象
 */
public class Run11_StringAndSyn2 {
    public static void main(String[] args) {
        ServiceB serviceB = new ServiceB();
        ThreadB a = new ThreadB(serviceB);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(serviceB);
        b.setName("B");
        b.start();
    }
}


/*
输出：
A
B
B
A
A
B
A
B
A
B
B
A
A
B

 */