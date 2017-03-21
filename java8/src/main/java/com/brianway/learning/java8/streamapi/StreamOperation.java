package com.brianway.learning.java8.streamapi;

import static com.brianway.learning.java8.streamapi.Dish.menu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by brian on 17/2/28.
 * 流操作:中间操作和终端操作
 * 流的延迟性质
 * 1. limit 操作,短路
 * 2. filter 和 map 操作, 循环合并
 */
public class StreamOperation {
    public static void main(String[] args) {
        List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);

        //forEach 是一个返回 void 的终端操作
        System.out.println("------forEach-------");
        menu.stream().forEach(System.out::println);
    }
}
