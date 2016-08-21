package com.brianway.learning.java.multithread.synchronize.example8;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P72
 * synchronized方法的弊端
 */
public class Run8_synchronized01 {
    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        MyThreadA thread1 = new MyThreadA(taskA);
        thread1.setName("a");
        thread1.start();

        MyThreadA thread2 = new MyThreadA(taskA);
        thread2.setName("b");
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime2 < CommonUtils.beginTime1 ? CommonUtils.beginTime2 : CommonUtils.beginTime1;
        long endTime = CommonUtils.endTime1 > CommonUtils.endTime2 ? CommonUtils.endTime1 : CommonUtils.endTime2;
        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }

}


/*
输出：
begin task
长时间处理任务后从远程返回的值1 threadName=a
长时间处理任务后从远程返回的值2 threadName=a
end task
begin task
长时间处理任务后从远程返回的值1 threadName=b
长时间处理任务后从远程返回的值2 threadName=b
end task
耗时：6

 */