package com.brianway.learning.java.multithread.synchronize.example5;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P67
 * synchronized锁重入，支持继承
 */
public class Run5_lockRein {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.operateIinSub();
            }
        };
        t.start();

    }

}

/*
输出：
sub print i=9
main print i=8
sub print i=7
main print i=6
sub print i=5
main print i=4
sub print i=3
main print i=2
sub print i=1
main print i=0
 */
