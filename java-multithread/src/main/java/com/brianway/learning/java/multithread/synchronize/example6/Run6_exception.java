package com.brianway.learning.java.multithread.synchronize.example6;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P68
 * 出现异常，锁自动释放
 */
public class Run6_exception {
    public static void main(String[] args) {

        try {
            Service service = new Service();
            ThreadA a = new ThreadA("a", service);
            a.start();
            Thread.sleep(500);
            ThreadB b = new ThreadB("b", service);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


/*
输出：
ThreadName=a run beginTime=1460455843215
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
ThreadName=a run exceptionTime=1460455843719
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
Thread b run Time=1460455843719
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.synchronize.example6.Service.testMethod(Service.java:15)
	at com.brianway.learning.java.multithread.synchronize.example6.ThreadA.run(ThreadA.java:16)

---------------

ThreadName=a run beginTime=1460455874981
ThreadName=a run exceptionTime=1460455875079
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.synchronize.example6.Service.testMethod(Service.java:15)
	at com.brianway.learning.java.multithread.synchronize.example6.ThreadA.run(ThreadA.java:16)
Thread b run Time=1460455875480



---------


ThreadName=a run beginTime=1460455887793
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.synchronize.example6.Service.testMethod(Service.java:15)
	at com.brianway.learning.java.multithread.synchronize.example6.ThreadA.run(ThreadA.java:16)
ThreadName=a run exceptionTime=1460455887945
Thread b run Time=1460455888293
 */