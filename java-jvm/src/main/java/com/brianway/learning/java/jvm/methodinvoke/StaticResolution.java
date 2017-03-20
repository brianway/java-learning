package com.brianway.learning.java.jvm.methodinvoke;

/**
 * Created by brian on 17/3/20.
 * 方法静态解析演示
 * javac -verbose StaticResolution.java
 * javap -verbose StaticResolution
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
