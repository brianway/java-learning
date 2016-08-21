package com.brianway.learning.java.multithread.lock.example8;

/**
 * Created by Brian on 2016/4/15.
 */

/**
 * P229
 * 测试方法boolean tryLock(long timeout,TimeUnit unit)
 * 作用：如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定
 */
public class Run8_tryLock_param {
    public static void main(String[] args) {
        final Service4 service = new Service4();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 调用waitMethod时间:" + System.currentTimeMillis());
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}

/*
输出：
A 调用waitMethod时间:1460718796935
B 调用waitMethod时间:1460718796935
B获得锁的时间:1460718796936
A没有获得锁

-------------------------
A 调用waitMethod时间:1460718824000
B 调用waitMethod时间:1460718824000
A获得锁的时间:1460718824000
B没有获得锁
 */