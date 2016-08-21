package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P26例子
 * 线程的中断状态由interrupted()清除
 */
public class Run9_interrupted02 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("Thread.interrupted()，是否停止1？=" + Thread.interrupted());
        System.out.println("Thread.interrupted()，是否停止2？=" + Thread.interrupted());
        System.out.println("end");
    }
}

/*
输出：
Thread.interrupted()，是否停止1？=true
Thread.interrupted()，是否停止2？=false
end

 */