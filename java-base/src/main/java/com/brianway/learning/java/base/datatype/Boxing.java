package com.brianway.learning.java.base.datatype;

/**
 * Created by Brian on 2016/4/14.
 *
 * TODO 有些细节待理解
 *
 * 主要是考装箱和拆箱
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
        System.out.println(new Integer(2) == new Integer(2));

    }
}

/*
输出：               原因:
true                自动装箱,缓存
false               自动装箱,未缓存
true
true                调用 equals(),比较的是值,而不是对象地址
true
false
false               比较的是对象地址

 */