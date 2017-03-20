package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/19.
 * 被动使用类字段演示
 * 常量在编译阶段会存入调用类的常量池,本质上没有引用调用常量的类,
 * 不会触发定义常量的类的初始化
 */
public class ConstClass {
    static {
        System.out.println("ConsClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
