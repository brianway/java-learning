package com.brianway.learning.java.multithread.communication.example2;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P137
 * 没有“对象监视器”，调用wait()方法出现运行时异常
 */
public class Run2_noObjectLock {
    public static void main(String[] args) {
        String s = new String("");
        try {
            s.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
Exception in thread "main" java.lang.IllegalMonitorStateException
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at com.brianway.learning.java.multithread.communication.example2.Run2_noObjectLock.main(Run2_noObjectLock.java:15)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

 */