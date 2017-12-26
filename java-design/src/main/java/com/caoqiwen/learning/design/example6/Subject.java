package com.caoqiwen.learning.design.example6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqiwen on 2017/12/18.
 * 抽象主题角色，可以增加观察者和被观察者
 */
public abstract class Subject {
    private static List<Observer> list = null;

    static {
        list = new ArrayList<>();
    }

    public void attch(Observer observer) {
        list.add(observer);
        System.out.println("Attached an observer");
    }

    public void detach(Observer observer) {
        list.remove(observer);
        System.out.println("Detached an observer");
    }

    public void notifyAllObserver(String newState) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(newState);
        }
    }
}
