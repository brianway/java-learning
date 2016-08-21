package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

/**
 * P39
 * suspend独占锁问题,println()
 */

class MyThread15 extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}

public class Run15_suspendAndresume03 {
    public static void main(String[] args) {
        try {
            MyThread15 myThread15 = new MyThread15();
            myThread15.start();
            Thread.sleep(1000);
            System.out.println("main before myThread15.suspend()!");
            myThread15.suspend();
            System.out.println("main end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
输出：
09162
309163
main before myThread15.suspend()!
309164
309165
309166
309167
309168
309169
309170
309171
309172
309173
309174
309175
309176
309177
309178
309179
309180
309181
309182
309183


 */