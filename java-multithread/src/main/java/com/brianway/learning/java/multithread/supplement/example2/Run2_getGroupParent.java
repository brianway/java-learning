package com.brianway.learning.java.multithread.supplement.example2;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * p288
 * 获取根线程组
 * JVM根线程组就是system
 */
public class Run2_getGroupParent {
    public static void main(String[] args) {
        System.out.println("线程：" + Thread.currentThread().getName()
                + " 所在的线程组名为：" + Thread.currentThread().getThreadGroup().getName());

        System.out.println("main线程所在的线程组的父线程组名为："
                + Thread.currentThread().getThreadGroup().getParent().getName());

        System.out.println("main线程所在的线程组的父线程组的父线程组名为："
                + Thread.currentThread().getThreadGroup().getParent().getParent().getName());

    }
}

/*
输出：
线程：main 所在的线程组名为：main
main线程所在的线程组的父线程组名为：system
Exception in thread "main" java.lang.NullPointerException
	at com.brianway.learning.java.multithread.supplement.example2.Run2_getGroupParent.main(Run2_getGroupParent.java:20)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
 */