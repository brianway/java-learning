package com.brianway.learning.java.base.datatype;

/**
 * Created by brian on 16/11/10.
 *
 * 包装类的“==”运算在不遇到算术运算的情况下不会自动拆箱;
 * 包装类的equals()方法不处理数据转型.
 */
public class NumberEquation {
    public static void main(String[] args) {
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;

        System.out.println(i.equals(d)); // false
        System.out.println(d.equals(l)); // false
        System.out.println(i.equals(l)); // false
        System.out.println(l.equals(42L)); // true
    }
}

// (i == l),(i == d),(l == d)会出现编译错误