package com.brianway.learning.java.multithread.synchronize.example8;

/**
 * Created by Brian on 2016/4/12.
 */
public class TaskB {
    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务后从远程返回的值1 threadName=" + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 threadName=" + Thread.currentThread().getName();
            synchronized (this) {
                //System.out.println("切换到线程begin："+Thread.currentThread().getName());
                getData1 = privateGetData1;
                getData2 = privateGetData2;
                //System.out.println("切换到线程end："+Thread.currentThread().getName());
            }

            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
