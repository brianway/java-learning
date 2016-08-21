package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P93
 * synchronized(非this对象x)的三个结论
 * 1）当多个线程同时执行synchronized(x){}同步代码块时呈现效果
 * 2）当其他线程执行x对象中synchronized同步方法时呈同步效果
 * 3）当其他线程执行x对象里面的synchronized(this)代码块时，也呈现同步效果
 * 验证结论2：
 * 当其他线程执行x对象中synchronized同步方法时呈同步效果
 */
public class Run9_synchronized02 {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject1 object1 = new MyObject1();

        MyThread a = new MyThread(service, object1);
        a.setName("a");
        a.start();
        Thread1 b = new Thread1(object1);
        b.setName("b");
        b.start();

    }

}


/*
输出：
testMethod1   ____getLock time=1460468427929 run ThreadName=a
testMethod1   releaseLock time=1460468429930 run ThreadName=a
speedPrintString   ____getLock time=1460468429930 run ThreadName=b
*******************
speedPrintString   releaseLock time=1460468429930 run ThreadName=b

 */