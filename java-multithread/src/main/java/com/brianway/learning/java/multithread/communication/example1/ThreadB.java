package com.brianway.learning.java.multithread.communication.example1;

/**
 * Created by Brian on 2016/4/13.
 */
public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //System.out.println("in b while: "+list.size());
                //synchronized ("any"){}
                if (list.size() == 5) {
                    System.out.println("达到size了，线程b要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
