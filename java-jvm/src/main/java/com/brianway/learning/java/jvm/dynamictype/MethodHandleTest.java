package com.brianway.learning.java.jvm.dynamictype;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * Created by brian on 17/3/20.
 * MethodHandle 演示
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("classA " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("brianway");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        // 方法类型
        MethodType mt = MethodType.methodType(void.class, String.class);

        return lookup().findVirtual(receiver.getClass(), "println", mt)
                .bindTo(receiver);
    }
}
