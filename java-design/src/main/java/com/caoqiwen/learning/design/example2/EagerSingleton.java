package com.caoqiwen.learning.design.example2;

/**
 * Created by caoqiwen on 2017/12/13.
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
