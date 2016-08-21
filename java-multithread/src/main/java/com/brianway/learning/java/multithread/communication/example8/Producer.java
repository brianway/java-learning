package com.brianway.learning.java.multithread.communication.example8;

/**
 * Created by Brian on 2016/4/14.
 */
public class Producer {
    private String lock;

    public Producer(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 " + Thread.currentThread().getName() + " WAITING了★");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName() + " RUNNABLE了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
