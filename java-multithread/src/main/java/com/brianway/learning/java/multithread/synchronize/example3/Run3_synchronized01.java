package com.brianway.learning.java.multithread.synchronize.example3;

/**
 * Created by Brian on 2016/4/12.
 */

/**
 * P60
 * synchronized方法与锁对象
 */
public class Run3_synchronized01 {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A ");
        ThreadB b = new ThreadB(object);
        b.setName("B ");
        a.start();
        b.start();
    }
}

/*
public void methodA()没加synchronized
输出：
begin methodA threadName=B
begin methodA threadName=A
A   end
B   end

-------------------

public void methodA()加synchronized
输出：
begin methodA threadName=A
A   end
begin methodA threadName=B
B   end

 */