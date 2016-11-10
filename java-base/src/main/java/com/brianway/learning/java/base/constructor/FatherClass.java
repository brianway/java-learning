package com.brianway.learning.java.base.constructor;

/**
 * Created by Brian on 2016/4/14.
 */
public class FatherClass {
    protected static int count = 10;
    private String name;

    static {
        System.out.println("父类的静态属性count初始化:" + count);
    }

    public FatherClass() {
        System.out.println("执行了父类的无参构造方法");
    }

    public FatherClass(String name) {
        this.name = name;
        System.out.println("执行了父类的构造方法FatherClass(String name) " + name);
    }
}
