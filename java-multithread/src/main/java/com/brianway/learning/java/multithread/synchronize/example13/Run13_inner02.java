package com.brianway.learning.java.multithread.synchronize.example13;

/**
 * Created by Brian on 2016/4/13.
 *
 * P112
 * 内置类与同步测试2
 *
 * T1和T3竞争in2的锁。只有T1结束，T3才能开始；或者T3结束，T1才能开始
 * T2与另外两个没关系，因为其锁对象是in2
 *
 * P112
 * 内置类与同步测试2
 *
 * T1和T3竞争in2的锁。只有T1结束，T3才能开始；或者T3结束，T1才能开始
 * T2与另外两个没关系，因为其锁对象是in2
 */

/**
 * P112
 * 内置类与同步测试2
 *
 * T1和T3竞争in2的锁。只有T1结束，T3才能开始；或者T3结束，T1才能开始
 * T2与另外两个没关系，因为其锁对象是in2
 */

import com.brianway.learning.java.multithread.synchronize.example13.OutClass2.InnerClass1;
import com.brianway.learning.java.multithread.synchronize.example13.OutClass2.InnerClass2;

public class Run13_inner02 {
    public static void main(String[] args) {
        final InnerClass1 in1 = new InnerClass1();
        final InnerClass2 in2 = new InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                in1.method1(in2);
            }
        }, "T1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                in1.method2();
            }
        }, "T2");

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                in2.method1();
            }
        }, "T3");

        t1.start();
        t2.start();
        t3.start();

    }
}


/*
输出：
T1 进入InnerClass1类中的method1方法
i=1
T2 进入InnerClass1类中的method2方法
j=1
j=2
i=2
j=3
i=3
j=4
i=4
j=5
i=5
j=6
i=6
j=7
i=7
i=8
j=8
i=9
j=9
j=10
i=10
T2 离开InnerClass1类中的method2方法
T1 离开InnerClass1类中的method1方法
T3 进入InnerClass2类中的method2方法
k=1
k=2
k=3
k=4
k=5
k=6
k=7
k=8
k=9
k=10
T3 离开InnerClass2类中的method2方法


--------------------------

T1 进入InnerClass1类中的method1方法
i=1
T2 进入InnerClass1类中的method2方法
j=1
j=2
i=2
i=3
j=3
j=4
i=4
i=5
j=5
j=6
i=6
j=7
i=7
i=8
j=8
i=9
j=9
j=10
i=10
T1 离开InnerClass1类中的method1方法
T3 进入InnerClass2类中的method2方法
k=1
T2 离开InnerClass1类中的method2方法
k=2
k=3
k=4
k=5
k=6
k=7
k=8
k=9
k=10
T3 离开InnerClass2类中的method2方法

-------------------------------
T3 进入InnerClass2类中的method2方法
k=1
T2 进入InnerClass1类中的method2方法
j=1
k=2
j=2
k=3
j=3
j=4
k=4
j=5
k=5
k=6
j=6
k=7
j=7
k=8
j=8
k=9
j=9
k=10
j=10
T3 离开InnerClass2类中的method2方法
T1 进入InnerClass1类中的method1方法
i=1
T2 离开InnerClass1类中的method2方法
i=2
i=3
i=4
i=5
i=6
i=7
i=8
i=9
i=10
T1 离开InnerClass1类中的method1方法

 */
