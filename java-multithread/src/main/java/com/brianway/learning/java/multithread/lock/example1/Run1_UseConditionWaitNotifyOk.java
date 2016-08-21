package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */

/**
 * P207
 * 正确使用Condition实现等待通知
 * Object类的wait()------Condition类的await()
 * Object类的wait(long timeout)------Condition类的await(long time,TimeUnit unit)
 * Object类的notify()------Condition类的signal()
 * Object类的notifyAll()------Condition类的signalAll()
 */
public class Run1_UseConditionWaitNotifyOk {
    public static void main(String[] args) throws InterruptedException {
        ServiceC service = new ServiceC();
        ThreadC c = new ThreadC(service);
        c.start();
        Thread.sleep(3000);
        service.signal();
    }
}


/*
输出：
await 时间为1460651340418
signal时间为1460651343418
锁释放了
 */