package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/20.
 * 字段解析
 * 如果注释了 Sub 类中的 "public static int A = 4",会编译错误
 */
public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;// 注释此句试试
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
