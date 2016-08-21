package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p277
 * 使用enum枚举数据类型实现单例模式
 * 完善
 */
public class Run3_singleton5 {
    public static void main(String[] args) {
        Thread5 t1 = new Thread5();
        Thread5 t2 = new Thread5();
        Thread5 t3 = new Thread5();
        t1.start();
        t2.start();
        t3.start();
    }
}


/*
输出:
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039
541962297 java.lang.Object@204db039


 */