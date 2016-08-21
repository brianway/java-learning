package com.brianway.learning.java.multithread.lock.example8;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P227
 * 测试方法 void lockInterruptibly()
 * 作用：如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。
 */
public class Run8_lockInterruptibly1 {
    public static void main(String[] args) throws InterruptedException {
        final Service1 service = new Service1();
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
main end
lock end   A
lock begin B
lock end   B
 */