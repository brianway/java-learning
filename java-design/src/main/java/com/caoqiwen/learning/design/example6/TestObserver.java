package com.caoqiwen.learning.design.example6;

/**
 * Created by caoqiwen on 2017/12/18.
 */
public class TestObserver {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attch(observer);
        subject.change("new state");
    }
}
