package com.caoqiwen.learning.design.example6;

/**
 * Created by caoqiwen on 2017/12/18.
 */
public class ConcreteObserver implements Observer {
    private String obserState;

    @Override
    public void update(String state) {
        this.obserState = state;
        System.out.println("状态为:" + state);
    }
}
