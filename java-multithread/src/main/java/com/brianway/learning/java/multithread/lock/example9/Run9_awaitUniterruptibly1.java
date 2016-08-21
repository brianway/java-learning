package com.brianway.learning.java.multithread.lock.example9;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P230
 * 测试方法awaitUniterruptibly()
 */
public class Run9_awaitUniterruptibly1 {
    public static void main(String[] args) {
        try {
            Service1 service = new Service1();
            Thread1 thread = new Thread1(service);
            thread.start();
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
wait begin
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.reportInterruptAfterWait(AbstractQueuedSynchronizer.java:2014)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2048)
	at com.brianway.learning.java.multithread.lock.example9.Service1.testMethod(Service1.java:17)
	at com.brianway.learning.java.multithread.lock.example9.Thread1.run(Thread1.java:15)
catch

-----------------------

wait begin
catch
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.reportInterruptAfterWait(AbstractQueuedSynchronizer.java:2014)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2048)
	at com.brianway.learning.java.multithread.lock.example9.Service1.testMethod(Service1.java:17)
	at com.brianway.learning.java.multithread.lock.example9.Thread1.run(Thread1.java:15)

 */