package com.brianway.learning.java.multithread.communication.example11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 2016/4/14.
 */
public class MyStack {
    private List list = new ArrayList();

    synchronized public void push() {
        try {
            while (list.size() == 1) {
                System.out.println("push操作中的： " + Thread.currentThread().getName() + " 线程呈wait状态");
                this.wait();
            }
            list.add(Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop操作中的： " + Thread.currentThread().getName() + " 线程呈wait状态");
                this.wait();
            }
            returnValue = list.get(0) + "  " + Thread.currentThread().getName();
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size() + "  Mystack的pop方法中 线程" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
