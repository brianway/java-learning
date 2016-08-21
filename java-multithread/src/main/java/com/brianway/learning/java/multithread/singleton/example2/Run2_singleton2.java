package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p267
 * 延迟加载/“懒汉模式”解决方案
 * 声明synchronized关键字，同步代码块
 * 效率低下
 */
public class Run2_singleton2 {
    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        Thread2 t2 = new Thread2();
        Thread2 t3 = new Thread2();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
974814630 com.brianway.learning.java.multithread.singleton.example2.MyObject2@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example2.MyObject2@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example2.MyObject2@3a1a7da6
 */