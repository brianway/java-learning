package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p275
 * 使用static代码块实现单例模式
 */
public class Run3_singleton3 {
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
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example3.MyObject3@3a1a7da6

 */