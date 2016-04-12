package com.brianway.learning.java.multithread.synchronize.example4;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P63
 * 两个线程访问同一个对象的不同方法
 * 1.一个方法有synchronized，一个没有。线程B可异步调用非synchronized类型方法
 * 2.两个都有synchronized。线程B需等待
 */
public class Run4_synchronized01 {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}

/*
public void methodB()没加synchronized
输出：
begin methodA threadName=A
begin methodB threadName=B
A  endTime:1460449260181
B  endTime:1460449260181

-------------------

public void methodB()加synchronized
输出：
begin methodA threadName=A
A  endTime:1460449301441
begin methodB threadName=B
B  endTime:1460449306441


 */