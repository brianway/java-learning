package com.brianway.learning.java.multithread.communication.example11;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P169
 * 多生产与一消费
 * notifyAll()代替notify()，将一直运行下去
 */
public class Run11_manyP_oneC {
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

        Consumer c = new Consumer(myStack);
        C_Thread c_thread = new C_Thread(c);
        c_thread.start();

    }
}


/*
一直运行
输出：
push = 1
push操作中的： Thread-3 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.13607547102959971  Thread-6  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-4 线程呈wait状态
push操作中的： Thread-0 线程呈wait状态
push操作中的： Thread-1 线程呈wait状态
push操作中的： Thread-2 线程呈wait状态
push操作中的： Thread-5 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.3177902565715548  Thread-6  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-3 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.5362657484190372  Thread-6  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-5 线程呈wait状态
push操作中的： Thread-2 线程呈wait状态
push操作中的： Thread-1 线程呈wait状态
push操作中的： Thread-0 线程呈wait状态
push操作中的： Thread-4 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.014856969053708147  Thread-6  Consumer的popService方法中打印pop返回值
push = 1
push操作中的： Thread-3 线程呈wait状态
pop = 0  Mystack的pop方法中 线程Thread-6
pop = 0.38033601579597587  Thread-6  Consumer的popService方法中打印pop返回值
 */