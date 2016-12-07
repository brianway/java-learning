package com.brianway.learning.java.base.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 对于泛型中创建数组,使用Array.newInstance()是推荐的方式
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker =
                new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
/* Output:
[null, null, null, null, null, null, null, null, null]
*///:~
