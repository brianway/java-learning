package com.brianway.learning.java.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */

/**
 * p264
 * 延迟加载/“懒汉模式”
 * 会出问题
 */
public class Run1_singleton1 {
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
541962297 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6

---------------------------

974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@3a1a7da6

--------------------------

1802892302 com.brianway.learning.java.multithread.singleton.example1.MyObject1@6b75f40e
974814630 com.brianway.learning.java.multithread.singleton.example1.MyObject1@6b75f40e
1771081048 com.brianway.learning.java.multithread.singleton.example1.MyObject1@6b75f40e

 */