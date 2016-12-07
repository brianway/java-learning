package com.brianway.learning.java.base.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 擦除的补偿
 * 显式传递类型的 Class 对象
 */
public class ClassTypeCapture<T> {
    //类型标签
    Class<T> kind;

    Map<String, Class<?>> types = new HashMap<>();

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}

class Building {
}

class House extends Building {
}

/* Output:
true
true
false
true
*///:~
