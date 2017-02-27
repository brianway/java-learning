package com.brianway.learning.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by brian on 17/2/27.
 * Java 8 中常用函数式接口
 */
public class FunctionDescriptor {

    public static void main(String[] args) {
        //使用 Predicate
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfStrings = Arrays.asList("aaa", "ss", "");
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println("nonEmpty.size() == 2  " + (nonEmpty.size() == 2));

        //使用 Consumer
        forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);

        //使用 Function
        List<Integer> lengthsOfWord = map(
                Arrays.asList("lambda", "in", "action"),
                String::length
        );
        forEach(lengthsOfWord, System.out::println);
    }

    /**
     * 使用 Predicate
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        //TODO
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    /**
     * 使用 Consumer
     */
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        //TODO
        for (T i : list) {
            c.accept(i);
        }
    }

    /**
     * 使用 Function
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        //TODO
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
