package com.caoqiwen.learning.design.example1;

/**
 * Created by caoqiwen on 2017/12/12.
 * 简单工厂
 * 格式化代码 ctrl +alt +l
 */
public class EasyFactory {

    public static Fruit getFruit(String fruitName) {
        Fruit fruit = null;
        if ("apple".equalsIgnoreCase(fruitName)) {
            fruit = new Apple();
        }

        if ("orange".equalsIgnoreCase(fruitName)) {
            fruit = new Orange();
        }
        return fruit;
    }

    public static void main(String[] args) {
        System.out.println("你好");

        Fruit fruit = EasyFactory.getFruit("apple");
        fruit.grow();
        Fruit fruit1 = EasyFactory.getFruit("orange");
        fruit1.havset();

    }
}
