package com.brianway.learning.java.multithread.synchronize.example8;

/**
 * Created by Brian on 2016/4/12.
 */
public class TaskA {
    private String getData1;
    private String getData2;

    public synchronized void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName=" + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName=" + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
