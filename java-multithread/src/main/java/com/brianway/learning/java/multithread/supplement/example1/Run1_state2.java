package com.brianway.learning.java.multithread.supplement.example1;

/**
 * Created by Brian on 2016/4/17.
 */

/**
 * P282
 * 验证TIMED_WAITING
 */
public class Run1_state2 {
    public static void main(String[] args) {
        try {
            Thread2 t = new Thread2();
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态：" + t.getState() + " of " + t.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/*
输出：
begin sleep,run方法中的状态：RUNNABLE of Thread-0
begin sleep,run方法中的状态：RUNNABLE of Thread-0
main方法中的状态：TIMED_WAITING of Thread-0
end sleep,run方法中的状态：RUNNABLE of Thread-0
end sleep,run方法中的状态：RUNNABLE of Thread-0
 */