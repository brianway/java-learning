package com.brianway.learning.java8.streamapi.usage;

import com.brianway.learning.java8.streamapi.Dish;
import static com.brianway.learning.java8.streamapi.Dish.menu;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * 使用流-映射
 * 注意扁平映射
 * flatMap 的效果:各个数组不是分别映射成一个流,而是映射成 流的内容
 */
public class Mapping {

    public static void main(String... args) {

        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[] {i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

        // flatMap
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[] {i, j})
                )
                .collect(toList());
        System.out.println("----------");
        pairs2.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
