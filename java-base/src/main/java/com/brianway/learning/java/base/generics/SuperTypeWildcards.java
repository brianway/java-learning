package com.brianway.learning.java.base.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆变
 * 超类型通配符
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }

    public static void main(String[] args) {
        SuperTypeWildcards.writeTo(new ArrayList<Fruit>());
    }
} ///:~
