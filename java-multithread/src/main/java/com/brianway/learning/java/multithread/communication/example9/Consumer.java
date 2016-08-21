package com.brianway.learning.java.multithread.communication.example9;

/**
 * Created by Brian on 2016/4/14.
 */
public class Consumer {
    private MyStack myStack;

    public Consumer(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop() + "  Consumer的popService方法中打印pop返回值");
    }

}
