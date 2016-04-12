package com.brianway.learning.java.multithread.synchronize.example2;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P58
 * 多个对象多个锁
 * 关键字synchronized取得的都是对象锁
 * 由于两个对象，所以是两个锁，没有同步问题。运行结果异步
 */
public class Run2_twoObject {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef1);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef2);
        threadB.start();
    }
}


/*
synchronized public void addI
输出：(注意顺序,由于两个对象，所以是两个锁，没有同步问题。运行结果异步)
a set over
b set over
b num= 200
a num= 100
*/