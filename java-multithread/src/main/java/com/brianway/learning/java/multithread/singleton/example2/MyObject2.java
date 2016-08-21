package com.brianway.learning.java.multithread.singleton.example2;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject2 {
    private static MyObject2 myObject;

    private MyObject2() {
    }

    public static MyObject2 getInstance() {

        try {
            //此写法和方法前加synchronized一样效率低下，全部代码被上锁
            synchronized (MyObject2.class) {
                if (myObject == null) {
                    Thread.sleep(3000);//模拟创建对象前的坐一些准备
                    myObject = new MyObject2();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
