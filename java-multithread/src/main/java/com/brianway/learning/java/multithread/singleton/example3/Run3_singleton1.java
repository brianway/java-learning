package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */


/**
 * p272
 * 使用静态内置类实现单例模式
 */
public class Run3_singleton1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
1802892302 com.brianway.learning.java.multithread.singleton.example3.MyObject1@65b21710
1802892302 com.brianway.learning.java.multithread.singleton.example3.MyObject1@65b21710
1802892302 com.brianway.learning.java.multithread.singleton.example3.MyObject1@65b21710
 */