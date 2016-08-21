package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */
public class MyService {
    synchronized static public void serviveMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " 进入了业务方法");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
