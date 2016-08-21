package com.brianway.learning.java.base.constructor;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * 构造方法调用问题
 * 子类构造方法会首先默认调用父类的无参构造方法，无论是否显式写了super();
 */
public class SonClass extends FatherClass {
    public SonClass(String name) {
        //super(name);
        System.out.println("执行了子类的构造方法SonClass(String name)");
    }

    public SonClass() {
        System.out.println("执行了子类的无参构造方法");
    }

    public static void main(String[] args) {
        new SonClass("aaa");
        new SonClass();
    }

}

/*
执行了父类的无参构造方法
执行了子类的构造方法SonClass(String name)
执行了父类的无参构造方法
执行了子类的无参构造方法
 */
