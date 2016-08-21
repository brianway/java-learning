package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P31例子
 * 先interrupt(),再进入sleep(),直接进异常
 */
class MyThread12 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到了sleep！进入catch");
            e.printStackTrace();
        }
    }
}

public class Run12_sleepAndinterrupt02 {
    public static void main(String[] args) {
        MyThread12 myThread12 = new MyThread12();
        myThread12.start();
        myThread12.interrupt();
        System.out.println("end！");
    }
}

/*
输出：
end！
i=1
i=2
i=3
i=4
省略。。。

i=99998
i=99999
i=100000
run begin
先停止，再遇到了sleep！进入catch
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.brianway.learning.java.multithread.meet.MyThread12.run(Run12_sleepAndinterrupt02.java:19)



 */