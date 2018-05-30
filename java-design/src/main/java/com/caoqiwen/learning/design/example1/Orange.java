package com.caoqiwen.learning.design.example1;

/**
 * Created by caoqiwen on 2017/12/12.
 */
public class Orange implements Fruit {
    @Override
    public void grow() {
        System.out.println("Orange is grow()");
    }

    @Override
    public void havset() {
        System.out.print("Orange is havset()");
    }

    @Override
    public void plant() {
        System.out.print("Orange is plant()");
    }
}
