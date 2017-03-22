package com.brianway.learning.java8.streamapi.collect;

import com.brianway.learning.java8.streamapi.Dish;
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
 * 1.建立新的结果容器: supplier 方法
 * 2.将元素添到结果容器: accumulator 方法
 * 3.对容器应用最终转换: finisher 方法
 * 4.合并两个结果容器: combiner
 * 5.characteristics 方法
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    /**
     * 创建集合操作的起始点
     */
    @Override
    public Supplier<List<T>> supplier() {
        //return () -> new ArrayList<T>();
        return ArrayList::new;
    }

    /**
     * 累积遍历过的项目,原位修改累加器
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        //return (list, item) -> list.add(item);
        return List::add;
    }

    /**
     * 恒等函数
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        //return i -> i;
        return Function.identity();
    }

    /**
     * 修改第一个累加器,将其与第二个累加器的内容合并
     * 返回第一个累加器
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 为收集器添加 IDENTITY_FINISH 和 CONCURRENT 标志
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }

    public static void main(String[] args) {
        List<Dish> dishes = menu.stream().collect(Collectors.toList());
        System.out.println(dishes);
        dishes = menu.stream().collect(new ToListCollector<>());
        System.out.println(dishes);
        // 进行自定义收集而不去实现 Collector
        dishes = menu.stream().collect(
                ArrayList::new,
                List::add,
                List::addAll);
        System.out.println(dishes);
    }
}
