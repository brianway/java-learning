package com.brianway.learning.java.multithread.communication.example8;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P161
 * 多生产与多消费，假死
 * 只需将Producer和Consumer类中的notify()改为notifyAll()即可让程序一直运行下去
 */
public class Run8_allWait {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] cThread = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadP(producer);
            pThread[i].setName("生产者" + (i + 1));
            cThread[i] = new ThreadC(consumer);
            cThread[i].setName("消费者" + (i + 1));
            pThread[i].start();
            cThread[i].start();
        }

        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }

    }
}

/*
输出：
消费者 消费者1 WAITING了☆
消费者 消费者2 WAITING了☆
生产者 生产者1 RUNNABLE了
生产者 生产者1 WAITING了★
生产者 生产者2 WAITING了★
消费者 消费者1 RUNNABLE了
消费者 消费者1 WAITING了☆
消费者 消费者2 WAITING了☆
main RUNNABLE
Monitor Ctrl-Break RUNNABLE
生产者1 WAITING
消费者1 WAITING
生产者2 WAITING
消费者2 WAITING

----------------------------

生产者 生产者1 RUNNABLE了
生产者 生产者1 WAITING了★
生产者 生产者2 WAITING了★
消费者 消费者1 RUNNABLE了
消费者 消费者1 WAITING了☆
生产者 生产者1 RUNNABLE了
生产者 生产者1 WAITING了★
生产者 生产者2 WAITING了★
消费者 消费者2 RUNNABLE了
消费者 消费者2 WAITING了☆
消费者 消费者1 WAITING了☆
main RUNNABLE
Monitor Ctrl-Break RUNNABLE
生产者1 WAITING
消费者1 WAITING
生产者2 WAITING
消费者2 WAITING

 */