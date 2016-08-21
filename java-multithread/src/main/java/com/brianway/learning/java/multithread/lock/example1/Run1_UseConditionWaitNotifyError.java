package com.brianway.learning.java.multithread.lock.example1;

/**
 * Created by brian on 2016/4/15.
 */

/**
 * P204
 * 使用Condition实现等待通知，展示错误用法
 * IllegalMonitorStateException，监视器出错
 */
public class Run1_UseConditionWaitNotifyError {
    public static void main(String[] args) {
        ServiceA service = new ServiceA();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}


/*
输出：
Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.fullyRelease(AbstractQueuedSynchronizer.java:1723)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2036)
	at com.brianway.learning.java.multithread.lock.example1.ServiceA.await(ServiceA.java:16)
	at com.brianway.learning.java.multithread.lock.example1.ThreadA.run(ThreadA.java:15)

 */