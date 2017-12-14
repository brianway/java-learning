package com.caoqiwen.learning.design.example3;

/**
 * Created by caoqiwen on 2017/12/13.
 */
public abstract class Prototype implements Cloneable {

    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prototype;
    }

    public abstract void show();
}
