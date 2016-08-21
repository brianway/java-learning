package com.brianway.learning.java.multithread.communication.example15;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * 188
 * 方法join后面的代码提前运行
 */
public class Run15_joinMore {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(1000);
            //for(int i =0;i<100000000;i++){
            //    if(i%1000000==0)System.out.print(i);
            //}
            System.out.println();
            System.out.println("main end timer=" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class ThreadA extends Thread {
        private ThreadB b;

        public ThreadA(ThreadB b) {
            super();
            this.b = b;
        }

        @Override
        public void run() {
            try {
                synchronized (b) {
                    System.out.println("A begin timer=" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
                    Thread.sleep(3000);
                    System.out.println("A end   timer=" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        synchronized public void run() {
            try {
                System.out.println("B begin timer=" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("B end   timer=" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

/*
输出：
A begin timer=1460639887068 threadName=Thread-1
A end   timer=1460639890069 threadName=Thread-1

B begin timer=1460639890069 threadName=Thread-0
main end timer=1460639890069 threadName=main
B end   timer=1460639893069 threadName=Thread-0

---------------------------

A begin timer=1460639939829 threadName=Thread-1
A end   timer=1460639942830 threadName=Thread-1

main end timer=1460639942830 threadName=main
B begin timer=1460639942830 threadName=Thread-0
B end   timer=1460639945830 threadName=Thread-0


 */