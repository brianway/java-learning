package com.brianway.learning.java.jvm.methodinvoke;

/**
 * Created by brian on 17/3/20.
 * 方法静态分派演示
 * Method Overload Resolution
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();

        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man)man);
        sr.sayHello((Woman) woman);
    }
}

/*
hello,guy!
hello,guy!
hello,gentleman!
hello,lady!
 */