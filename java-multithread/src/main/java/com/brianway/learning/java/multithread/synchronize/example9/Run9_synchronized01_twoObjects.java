package com.brianway.learning.java.multithread.synchronize.example9;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P93
 * 不同的“对象监视器”
 */
public class Run9_synchronized01_twoObjects {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();

        MyThread a = new MyThread(service, object1);
        a.setName("a");
        a.start();
        MyThread b = new MyThread(service, object2);
        b.setName("b");
        b.start();

    }
}

/*
输出：
testMethod1   ____getLock time=1460467346174 run ThreadName=a
testMethod1   ____getLock time=1460467346174 run ThreadName=b
testMethod1   releaseLock time=1460467348174 run ThreadName=a
testMethod1   releaseLock time=1460467348174 run ThreadName=b

 */