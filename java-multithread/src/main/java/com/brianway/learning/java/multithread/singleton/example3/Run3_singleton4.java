package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p276
 * 使用enum枚举数据类型实现单例模式
 */
public class Run3_singleton4 {
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
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba
61956794 java.lang.Object@3b162ba


 */