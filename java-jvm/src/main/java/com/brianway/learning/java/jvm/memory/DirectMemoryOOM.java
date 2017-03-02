package com.brianway.learning.java.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by brian on 17/3/2.
 * 使用 unsafe 分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}

/*
TODO 没出现 OOM
 */