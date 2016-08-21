package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p270
 * 延迟加载/“懒汉模式”解决方案
 * DCL双检查锁机制
 */
public class Run2_singleton4 {
    public static void main(String[] args) {
        Thread4 t1 = new Thread4();
        Thread4 t2 = new Thread4();
        Thread4 t3 = new Thread4();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
2110701623 com.brianway.learning.java.multithread.singleton.example2.MyObject4@7dcec037
2110701623 com.brianway.learning.java.multithread.singleton.example2.MyObject4@7dcec037
2110701623 com.brianway.learning.java.multithread.singleton.example2.MyObject4@7dcec037
 */