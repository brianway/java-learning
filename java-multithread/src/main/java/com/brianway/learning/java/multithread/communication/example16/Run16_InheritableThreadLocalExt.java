package com.brianway.learning.java.multithread.communication.example16;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P198
 * 类InheritableThreadLocal使用，值继承，子线程从父线程取得值
 */
public class Run16_InheritableThreadLocalExt {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.itl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadB b = new ThreadB();
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在Main线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
在ThreadB线程中取值=1460642917909
 */