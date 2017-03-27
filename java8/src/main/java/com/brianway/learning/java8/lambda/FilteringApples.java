package com.brianway.learning.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by brian on 16/12/26.
 *
 * 传递代码的例子
 * 分别使用了方法引用和Lambda(匿名函数)
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filter(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> greenApples2 = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> heavyApples2 = filter(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

    }

    /**
     * 根据抽象条件筛选
     * 将迭代集合的逻辑和要应用到集合中每个元素的行为区分开
     *
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
