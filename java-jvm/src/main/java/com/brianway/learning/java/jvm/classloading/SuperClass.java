package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/19.
 * 被动引用的例子
 * 通过子类引用父类的静态字段,不会导致子类初始化
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
