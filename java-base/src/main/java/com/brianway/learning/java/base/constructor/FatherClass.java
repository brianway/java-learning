package com.brianway.learning.java.base.constructor;

/**
 * Created by Brian on 2016/4/14.
 */
public class FatherClass {
    private String name;

    public FatherClass(){
        System.out.println("执行了父类的无参构造方法");
    }

    public FatherClass(String name) {
        this.name = name;
        System.out.println("执行了父类的构造方法FatherClass(String name)");
    }
}
