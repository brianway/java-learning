package com.brianway.learning.java.multithread.communication.example11;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P170
 * 多生产与多消费
 *
 * 一直运行下去
 */
public class Run11_manyP_manyC {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        int pNum = 6;
        Producer[] producers = new Producer[pNum];
        P_Thread[] p_threads = new P_Thread[pNum];

        for (int i = 0; i < pNum; i++) {
            producers[i] = new Producer(myStack);
        }

        for (int i = 0; i < pNum; i++) {
            p_threads[i] = new P_Thread(producers[i]);
            p_threads[i].start();
        }

        int cNum = 8;
        Consumer[] consumers = new Consumer[cNum];
        C_Thread[] c_threads = new C_Thread[cNum];

        for (int i = 0; i < cNum; i++) {
            consumers[i] = new Consumer(myStack);
        }

        for (int i = 0; i < cNum; i++) {
            c_threads[i] = new C_Thread(consumers[i]);
            c_threads[i].start();
        }

    }
}

/*
输出：
push = 1
push操作中的： Thread-0 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-13
pop = 0.7346685371683742  Thread-13  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-9 线程呈wait状态
pop操作中的： Thread-7 线程呈wait状态
push = 1
push操作中的： Thread-5 线程呈wait状态
push操作中的： Thread-1 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-12
pop = 0.33456421914779433  Thread-12  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-4 线程呈wait状态
push操作中的： Thread-3 线程呈wait状态
push操作中的： Thread-2 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.37570391569907924  Thread-6  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-11 线程呈wait状态
pop操作中的： Thread-10 线程呈wait状态
pop操作中的： Thread-8 线程呈wait状态
pop操作中的： Thread-6 线程呈wait状态
push = 1
push操作中的： Thread-2 线程呈wait状态
push操作中的： Thread-3 线程呈wait状态
push操作中的： Thread-4 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-12
pop = 0.20512556002122917  Thread-12  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-1 线程呈wait状态
push操作中的： Thread-5 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-7
pop = 0.7027033632078373  Thread-7  Consumer的popService方法中打印pop返回值
pop操作中的： Thread-9 线程呈wait状态
pop操作中的： Thread-13 线程呈wait状态

 */