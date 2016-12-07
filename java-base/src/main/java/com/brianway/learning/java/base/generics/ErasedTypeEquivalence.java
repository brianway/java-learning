package com.brianway.learning.java.base.generics;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        Class c3 = ArrayList.class;
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
/* Output:
true
true
*///:~
