package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/19.
 * 非主动使用类字段演示
 * 1. 静态字段只有直接定义这个字段的类才会被初始化
 * 2. 通过数组来定义引用类,不会触发类的初始化
 * (-XX:+TraceClassLoading,对于 HotSpot 虚拟机可观察到子类的加载)
 */
public class NoInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        SubClass[] sca = new SubClass[10];

        System.out.println(ConstClass.HELLOWORLD);
    }
}
/*
SuperClass init!
123
 */