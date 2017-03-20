package com.brianway.learning.java.jvm.classloading;

/**
 * Created by brian on 17/3/20.
 * <clinit>() 方法执行顺序
 */
public class ClinitOrder {
    static class Parent {
        public static int A = 1;

        static {
            System.out.println("execute before A = 2, A now is " + A);
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }


    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}


