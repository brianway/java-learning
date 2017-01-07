package com.brianway.learning.java8.streamapi;

import static com.brianway.learning.java8.streamapi.Dish.menu;
import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 自定义 ToListCollector
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<T>();
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return i -> i;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }

    public static void main(String[] args) {
        List<Dish> dishes = menu.stream().collect(Collectors.toList());
        System.out.println(dishes);
        dishes = menu.stream().collect(new ToListCollector<>());
        System.out.println(dishes);
        dishes = menu.stream().collect(
                ArrayList::new,
                List::add,
                List::addAll);
        System.out.println(dishes);
    }
}
