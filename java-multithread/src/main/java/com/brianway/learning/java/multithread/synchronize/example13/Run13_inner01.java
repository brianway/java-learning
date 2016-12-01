package com.brianway.learning.java.multithread.synchronize.example13;

/**
 * Created by Brian on 2016/4/13.
 *
 * P112
 * 内置类和同步测试1
 */

import com.brianway.learning.java.multithread.synchronize.example13.OutClass.Inner;

public class Run13_inner01 {
    public static void main(String[] args) {
        final Inner inner = new Inner();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        }, "B");
        t1.start();
        t2.start();
    }
}

/*
输出：
A i=1
B i=11
B i=12
A i=2
A i=3
B i=13
B i=14
A i=4
A i=5
B i=15
B i=16
A i=6
B i=17
A i=7
A i=8
B i=18
B i=19
A i=9
A i=10
B i=20

 */