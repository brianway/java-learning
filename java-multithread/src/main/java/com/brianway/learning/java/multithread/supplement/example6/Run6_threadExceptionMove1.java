package com.brianway.learning.java.multithread.supplement.example6;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P303
 */
public class Run6_threadExceptionMove1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //对象
        //myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        //类
        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());

        myThread.start();
    }

}

/*
//对象
myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
//类
MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
输出：
对象的异常处理
java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.supplement.example6.MyThread.run(MyThread.java:18)


---------------------------
//对象
//myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
//类
MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
输出：
静态的异常处理
java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.brianway.learning.java.multithread.supplement.example6.MyThread.run(MyThread.java:18)

 */