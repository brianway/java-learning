package com.brianway.learning.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by brian on 17/2/28.
 * 构造函数引用
 */
public class ConstructorReference {

    public static void main(String[] args) {
        //Apple()的构造函数
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        System.out.println(a1);

        //Apple(int weight)的构造函数
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110);
        System.out.println(a2);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println("list of weights:");
        apples.stream().forEach(System.out::println);

        //Apple(int weight, String color)的构造函数
        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("green", 110);
        System.out.println(a3);
    }

    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        //TODO
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(String color, int weight) {
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
