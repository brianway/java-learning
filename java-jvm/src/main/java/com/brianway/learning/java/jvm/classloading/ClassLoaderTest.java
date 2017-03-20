package com.brianway.learning.java.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by brian on 17/3/20.
 * 不同的类加载器对 instanceof 关键字运算结果的影响
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.brianway.learning.java.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.brianway.learning.java.jvm.classloading.ClassLoaderTest);
    }
}

/*
class com.brianway.learning.java.jvm.classloading.ClassLoaderTest
false
 */