package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/15.
 * 一段简单的 Java 代码,用于分析字节码
 * javap -verbose SimpleClass.java
 */
public class SimpleClass {
    private int m;

    public int inc() {
        return m + 1;
    }
}
