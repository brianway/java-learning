package com.brianway.learning.java.base.typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {

        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing

        Class intClass = int.class;
        intClass = double.class;
        // genericIntClass = double.class; // Illegal

        System.out.println(int.class == Integer.class);
    }
} ///:~
