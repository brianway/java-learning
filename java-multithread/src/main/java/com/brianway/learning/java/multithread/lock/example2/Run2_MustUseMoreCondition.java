package com.brianway.learning.java.multithread.lock.example2;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P210
 * 使用多个condition实现通知部分线程
 */
public class Run2_MustUseMoreCondition {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAll_A();
    }
}


/*
输出：
awaitA begin时间为1460687242048 ThreadName=A
awaitB begin时间为1460687242048 ThreadName=B
signalAll_A 时间为1460687245048 ThreadName=main
awaitA end  时间为1460687245048 ThreadName=A
A锁释放了  时间为1460687245048 ThreadName=A
 */