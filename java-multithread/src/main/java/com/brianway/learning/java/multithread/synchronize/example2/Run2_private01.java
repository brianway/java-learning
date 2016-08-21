package com.brianway.learning.java.multithread.synchronize.example2;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P55
 * 实例变量非线程安全
 */
public class Run2_private01 {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();
    }
}

/*
//synchronized
    public void addI(String username)
输出：
a set over
b set over
b num= 200
a num= 200

---------------
HasSelfPrivateNum中addI加synchronized
输出：(注意顺序)
a set over
a num= 100
b set over
b num= 200


 */