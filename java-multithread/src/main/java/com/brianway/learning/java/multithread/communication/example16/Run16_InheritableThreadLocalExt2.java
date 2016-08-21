package com.brianway.learning.java.multithread.communication.example16;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P198
 * 类InheritableThreadLocal使用，值继承再更改
 */
public class Run16_InheritableThreadLocalExt2 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.itl2.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadC c = new ThreadC();
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在Main线程中取值=1460642947324
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
在ThreadC线程中取值=1460642947324我在子线程加的~
 */