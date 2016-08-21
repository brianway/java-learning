package com.brianway.learning.java.multithread.synchronize.example1;

/**
 * Created by Brian on 2016/4/11.
 */

public class HasLocalNum {
    public void addI(String username) {
        try {
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(1000);

            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + " num= " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
