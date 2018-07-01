package com.caoqiwen.learning.design.example6;

/**
 * Created by caoqiwen on 2017/12/18.
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主体状态为:" + state);
        this.notifyAllObserver(state);
    }
}
