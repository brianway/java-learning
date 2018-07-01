package com.caoqiwen.learning.design.example3;

/**
 * Created by caoqiwen on 2017/12/13.
 */
public class Client {


    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        for (int i = 0; i < 10; i++) {
            ConcretePrototype concretePrototype = (ConcretePrototype) cp.clone();
            concretePrototype.show();

        }
    }

}
