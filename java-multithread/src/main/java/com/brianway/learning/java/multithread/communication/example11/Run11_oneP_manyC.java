package com.brianway.learning.java.multithread.communication.example11;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P169
 * 一生产与多消费
 * notifyAll()代替notify()，将一直运行下去
 */
public class Run11_oneP_manyC {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer p = new Producer(myStack);

        P_Thread p_thread = new P_Thread(p);
        p_thread.start();

        int cNum = 5;
        Consumer[] consumers = new Consumer[cNum];
        C_Thread[] c_threads = new C_Thread[cNum];

        for (int i = 0; i < cNum; i++) {
            consumers[i] = new Consumer(myStack);
        }

        for (int i = 0; i < cNum; i++) {
            c_threads[i] = new C_Thread(consumers[i]);
        }

        for (int i = 0; i < cNum; i++) {
            c_threads[i].start();
        }

    }
}

/*
一直运行
输出：
Thread-5 线程呈wait状态
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-4 线程呈wait状态
pop操作中的： Thread-3 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-2
pop = 0.8265055169880213  Thread-2  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-3 线程呈wait状态
pop操作中的： Thread-4 线程呈wait状态
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-5 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-2
pop = 0.9282185161913705  Thread-2  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-5 线程呈wait状态
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-4 线程呈wait状态
pop操作中的： Thread-3 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
push = 1
push操作中的： Thread-0 线程呈wait状态
 */