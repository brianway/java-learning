package com.brianway.learning.java.multithread.supplement.example5;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * p300
 * 线程组内处理异常
 */
public class Run5_threadGroup2 {
    public static void main(String[] args) {
        ThreadGroup2 group = new ThreadGroup2("Brian's group");
        Thread2[] threads = new Thread2[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread2(group, "线程" + (i + 1), "1");
            threads[i].start();
        }
        Thread2 newT = new Thread2(group, "线程报错", "a");
        newT.start();
    }
}

/*
输出：
死循环中：线程6
死循环中：线程7
死循环中：线程8
死循环中：线程4
死循环中：线程1
死循环中：线程5
死循环中：线程9
Exception in thread "线程报错" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.supplement.example5.Thread2.run(Thread2.java:16)
 */