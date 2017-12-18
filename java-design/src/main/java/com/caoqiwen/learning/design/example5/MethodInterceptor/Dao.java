package com.caoqiwen.learning.design.example5.MethodInterceptor;

/**
 * Created by caoqiwen on 2017/12/16.
 */
public class Dao {

    public void update() {
        System.out.println("update dao has begined");
    }

    public void select() {
        System.out.println("select dao has  begined");
    }
}
