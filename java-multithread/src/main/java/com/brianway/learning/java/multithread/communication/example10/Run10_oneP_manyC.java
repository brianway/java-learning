package com.brianway.learning.java.multithread.communication.example10;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P168
 * 一生产与多消费
 *
 * while判断解决条件发生改变时没有得到及时的响应，多个呈wait状态的线程被唤醒的问题
 * 但会出现新的问题：假死
 */
public class Run10_oneP_manyC {
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
输出：
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-1
pop = 0.28218649074189095  Thread-1  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-3
pop = 0.26526620276366075  Thread-3  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-3 线程呈wait状态
pop操作中的： Thread-1 线程呈wait状态
pop操作中的： Thread-2 线程呈wait状态
pop操作中的： Thread-5 线程呈wait状态
pop操作中的： Thread-4 线程呈wait状态

 */