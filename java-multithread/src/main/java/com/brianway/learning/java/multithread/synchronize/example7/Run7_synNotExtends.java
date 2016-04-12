package com.brianway.learning.java.multithread.synchronize.example7;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P71
 * 同步不具继承性
 */
public class Run7_synNotExtends {
    public static void main(String[] args) {
        Sub sub = new Sub();
        MyThread a = new MyThread(sub);
        a.setName("A");
        a.start();
        MyThread b = new MyThread(sub);
        b.setName("B");
        b.start();
    }
}

/*
Sub的testMethod不加synchronized
输出:
threadName= A in sub 下一步 sleep begin time =1460457287103
threadName= B in sub 下一步 sleep begin time =1460457287103
threadName= A in sub 下一步 sleep end time =1460457289103
threadName= B in sub 下一步 sleep end time =1460457289103
threadName= A in main 下一步 sleep begin time =1460457289103
threadName= A in main 下一步 sleep end time =1460457291103
threadName= B in main 下一步 sleep begin time =1460457291103
threadName= B in main 下一步 sleep end time =1460457293103

--------------------
Sub的testMethod加synchronized
输出:
threadName= A in sub 下一步 sleep begin time =1460457463877
threadName= A in sub 下一步 sleep end time =1460457465878
threadName= A in main 下一步 sleep begin time =1460457465878
threadName= A in main 下一步 sleep end time =1460457470879
threadName= B in sub 下一步 sleep begin time =1460457470879
threadName= B in sub 下一步 sleep end time =1460457472879
threadName= B in main 下一步 sleep begin time =1460457472879
threadName= B in main 下一步 sleep end time =1460457477879

 */