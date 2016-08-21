package com.brianway.learning.java.multithread.communication.example6;

/**
 * Created by Brian on 2016/4/14.
 */
public class Add {
    private String lock;

    public Add(String lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
