package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p262
 * 立即加载/“饿汉模式”
 */
public class Run1_singleton0 {
    public static void main(String[] args) {
        Thread0 t1 = new Thread0();
        Thread0 t2 = new Thread0();
        Thread0 t3 = new Thread0();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
663838472 com.brianway.learning.java.multithread.singleton.example1.MyObject0@27915f08
663838472 com.brianway.learning.java.multithread.singleton.example1.MyObject0@27915f08
663838472 com.brianway.learning.java.multithread.singleton.example1.MyObject0@27915f08
 */