package com.brianway.learning.java.multithread.meet;

/**
 * Created by Brian on 2016/4/11.
 */

import java.util.Random;

/**
 * P45例子
 * 优先级具有规则性
 */

class MyThread18_1 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★★★★★ thread1 use time = " + (endTime - beginTime));
    }
}

class MyThread18_2 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆☆☆ thread2 use time = " + (endTime - beginTime));
    }
}

public class Run18_priority02 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread18_1 myThread18_1 = new MyThread18_1();
            myThread18_1.setPriority(10);
            //myThread18_1.setPriority(1);
            myThread18_1.start();
            MyThread18_2 myThread18_2 = new MyThread18_2();
            //myThread18_2.setPriority(10);
            myThread18_2.setPriority(1);
            myThread18_2.start();
        }
    }
}


/*
myThread18_1.setPriority(10);
myThread18_2.setPriority(1);
输出：
☆☆☆☆☆ thread2 use time = 202
★★★★★ thread1 use time = 208
★★★★★ thread1 use time = 255
★★★★★ thread1 use time = 261
★★★★★ thread1 use time = 268
★★★★★ thread1 use time = 270
☆☆☆☆☆ thread2 use time = 321
☆☆☆☆☆ thread2 use time = 338
☆☆☆☆☆ thread2 use time = 344
☆☆☆☆☆ thread2 use time = 35

-------------------------

★★★★★ thread1 use time = 121
★★★★★ thread1 use time = 232
☆☆☆☆☆ thread2 use time = 268
☆☆☆☆☆ thread2 use time = 292
★★★★★ thread1 use time = 322
☆☆☆☆☆ thread2 use time = 325
★★★★★ thread1 use time = 387
☆☆☆☆☆ thread2 use time = 390
★★★★★ thread1 use time = 395
☆☆☆☆☆ thread2 use time = 409


----------------------------------------------------
----------------------------------------------------
myThread18_1.setPriority(1);
myThread18_2.setPriority(10);
输出：

☆☆☆☆☆ thread2 use time = 393
☆☆☆☆☆ thread2 use time = 455
☆☆☆☆☆ thread2 use time = 496
☆☆☆☆☆ thread2 use time = 509
☆☆☆☆☆ thread2 use time = 510
★★★★★ thread1 use time = 511
★★★★★ thread1 use time = 554
★★★★★ thread1 use time = 558
★★★★★ thread1 use time = 561
★★★★★ thread1 use time = 569

---------------

☆☆☆☆☆ thread2 use time = 214
☆☆☆☆☆ thread2 use time = 230
☆☆☆☆☆ thread2 use time = 237
★★★★★ thread1 use time = 257
☆☆☆☆☆ thread2 use time = 261
☆☆☆☆☆ thread2 use time = 271
★★★★★ thread1 use time = 350
★★★★★ thread1 use time = 369
★★★★★ thread1 use time = 339
★★★★★ thread1 use time = 382

 */