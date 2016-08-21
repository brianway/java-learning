package com.brianway.learning.java.multithread.communication.example11;

/**
 * Created by Brian on 2016/4/14.
 */
public class Producer {
    private MyStack myStack;

    public Producer(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }

}
