package com.brianway.learning.java.multithread.lock.example8;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P228
 * 测试方法 void lockInterruptibly()
 * 作用：如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。
 */
public class Run8_lockInterruptibly2 {
    public static void main(String[] args) throws InterruptedException {
        final Service2 service = new Service2();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
        threadB.interrupt();
        System.out.println("main end");

    }
}

/*
输出：
lock begin A
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1220)
	at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
	at com.brianway.learning.java.multithread.lock.example8.Service2.waitMethod(Service2.java:15)
	at com.brianway.learning.java.multithread.lock.example8.Run8_lockInterruptibly2$1.run(Run8_lockInterruptibly2.java:17)
	at java.lang.Thread.run(Thread.java:745)
main end
lock end   A

-----------------------------

lock begin A
main end
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1220)
	at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
	at com.brianway.learning.java.multithread.lock.example8.Service2.waitMethod(Service2.java:15)
	at com.brianway.learning.java.multithread.lock.example8.Run8_lockInterruptibly2$1.run(Run8_lockInterruptibly2.java:17)
	at java.lang.Thread.run(Thread.java:745)
lock end   A


 */