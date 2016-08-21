package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p266
 * 延迟加载/“懒汉模式”解决方案
 * 声明synchronized关键字，整个方法上锁
 * 效率低下，下一个线程想取得对象，须等上一个线程释放锁
 */
public class Run2_singleton1 {
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
872395065 com.brianway.learning.java.multithread.singleton.example2.MyObject1@33ffb139
872395065 com.brianway.learning.java.multithread.singleton.example2.MyObject1@33ffb139
872395065 com.brianway.learning.java.multithread.singleton.example2.MyObject1@33ffb139


 */