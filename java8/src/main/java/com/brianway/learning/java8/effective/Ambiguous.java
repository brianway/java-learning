package com.brianway.learning.java8.effective;

/**
 * 默认方法解决冲突
 */
public class Ambiguous {

    public static void main(String... args) {
        new C().hello();
    }

    interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    interface B {
        default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
        public void hello() {
            A.super.hello();// Java 8 引入的新语法: X.super.m(...)
            // 其中 X 为希望调用 m 方法所在的父接口
        }
    }
}
