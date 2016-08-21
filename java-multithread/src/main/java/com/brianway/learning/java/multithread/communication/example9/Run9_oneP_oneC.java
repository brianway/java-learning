package com.brianway.learning.java.multithread.communication.example9;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P166
 * 一生产与一消费
 */
public class Run9_oneP_oneC {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer p = new Producer(myStack);
        Consumer c = new Consumer(myStack);
        P_Thread p_thread = new P_Thread(p);
        C_Thread c_thread = new C_Thread(c);

        p_thread.start();
        c_thread.start();
    }
}

/*
一直运行
输出：
push = 1
pop = 0  Mystack的pop方法中 线程Thread-1
pop = 0.21477079298150648  Thread-1  Consumer的popService方法中打印pop返回值
push = 1
pop = 0  Mystack的pop方法中 线程Thread-1
pop = 0.09214474637906356  Thread-1  Consumer的popService方法中打印pop返回值
push = 1
pop = 0  Mystack的pop方法中 线程Thread-1
pop = 0.7039441044726136  Thread-1  Consumer的popService方法中打印pop返回值
push = 1
pop = 0  Mystack的pop方法中 线程Thread-1
pop = 0.9344339682446102  Thread-1  Consumer的popService方法中打印pop返回值
 */