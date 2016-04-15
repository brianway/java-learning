package com.brianway.learning.java.base;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * TODO
 * 待理解。
 * 应该是考装箱和拆箱
 */
public class Boxing {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }
}

/*
输出：
true
false
true
true
true
false
 */