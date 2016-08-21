package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p269
 * 延迟加载/“懒汉模式”解决方案
 * 声明synchronized关键字，部分代码上锁
 * 会出问题
 */
public class Run2_singleton3 {
    public static void main(String[] args) {
        Thread3 t1 = new Thread3();
        Thread3 t2 = new Thread3();
        Thread3 t3 = new Thread3();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
541962297 com.brianway.learning.java.multithread.singleton.example2.MyObject3@3b162ba
974814630 com.brianway.learning.java.multithread.singleton.example2.MyObject3@3b162ba
61956794 com.brianway.learning.java.multithread.singleton.example2.MyObject3@3b162ba
 */