package com.brianway.learning.java.multithread.communication.example6;

/**
 * Created by Brian on 2016/4/14.
 */
public class Subtract {
    private String lock;

    public Subtract(String lock) {
        super();
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                //while(ValueObject.list.size() == 0){
                if (ValueObject.list.size() == 0) {
                    System.out.println("begin wait(),ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("end wait(),  ThreadName=" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size = " + ValueObject.list.size());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
