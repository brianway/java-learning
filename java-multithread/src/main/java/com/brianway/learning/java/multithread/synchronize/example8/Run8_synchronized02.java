package com.brianway.learning.java.multithread.synchronize.example8;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P76
 * 同步代码块解决同步方法的弊端
 * TODO 但输出并不是两个c,两个d，原因？
 */
public class Run8_synchronized02 {
    public static void main(String[] args) {
        TaskB taskB = new TaskB();
        MyThreadB thread1 = new MyThreadB(taskB);
        thread1.setName("c");
        thread1.start();

        MyThreadB thread2 = new MyThreadB(taskB);
        thread2.setName("d");
        thread2.start();

        try {
            Thread.sleep(5000);
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
begin task
长时间处理任务后从远程返回的值1 threadName=c
长时间处理任务后从远程返回的值2 threadName=d
end task
长时间处理任务后从远程返回的值1 threadName=d
长时间处理任务后从远程返回的值2 threadName=d
end task
耗时：3
 */