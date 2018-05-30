package com.brianway.learning.java.concurrent;

/**
 * Created by caoqiwen on 2018/2/23.
 */
public class DeadLock {

    private final Object left = new Object();
    private final Object right = new Object();


    public void leftRight() throws InterruptedException {
        synchronized (left) {
            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("leftRight has end");
            }
        }
    }

    public void rightLeft() throws InterruptedException {
        synchronized (right) {
            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("rightLeft has end");
            }
        }
    }

    static class Thread0 extends Thread {
        private DeadLock deadLock;

        public Thread0(DeadLock deadLock) {
            this.deadLock = deadLock;
        }

        @Override
        public void run() {
            super.run();
            try {
                deadLock.leftRight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread1 extends Thread {
        private DeadLock deadLock;

        public Thread1(DeadLock deadLock) {
            this.deadLock = deadLock;
        }

        @Override
        public void run() {
            //super.run();
            try {
                deadLock.rightLeft();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        DeadLock deadLock = new DeadLock();
        Thread thread0 = new Thread(new Thread0(deadLock));
        thread0.start();
        Thread thread1 = new Thread(new Thread1(deadLock));
        thread1.start();
    }
}
