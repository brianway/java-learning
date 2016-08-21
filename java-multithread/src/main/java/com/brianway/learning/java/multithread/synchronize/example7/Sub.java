package com.brianway.learning.java.multithread.synchronize.example7;

/**
 * Created by Brian on 2016/4/12.
 */
public class Sub extends Main {
    //synchronized
    public void testMethod() {
        try {
            System.out.println("threadName= " + Thread.currentThread().getName() + " in sub 下一步 sleep begin time =" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("threadName= " + Thread.currentThread().getName() + " in sub 下一步 sleep end time =" + System.currentTimeMillis());
            super.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
