package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p265
 * 延迟加载/“懒汉模式”缺点展示
 */
public class Run1_singleton2 {
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
1771081048 com.brianway.learning.java.multithread.singleton.example1.MyObject2@6b75f40e
1802892302 com.brianway.learning.java.multithread.singleton.example1.MyObject2@6b75f40e
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject2@6b75f40e

 */