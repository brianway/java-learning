package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * 线程组自动归属特性
 */
public class Run2_autoAddGroup {
    public static void main(String[] args) {
        System.out.println("A处线程：" + Thread.currentThread().getName()
                + " 所属的线程组名为：" + Thread.currentThread().getThreadGroup().getName()
                + " 中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup group = new ThreadGroup("新的组");

        System.out.println("A处线程：" + Thread.currentThread().getName()
                + " 所属的线程组名为：" + Thread.currentThread().getThreadGroup().getName()
                + " 中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup);
        for (int i = 0; i < threadGroup.length; i++) {
            System.out.println("第一个线程组名称为：" + threadGroup[i].getName());
        }

    }
}

/*
输出：
A处线程：main 所属的线程组名为：main 中有线程组数量：0
A处线程：main 所属的线程组名为：main 中有线程组数量：1
第一个线程组名称为：新的组

 */