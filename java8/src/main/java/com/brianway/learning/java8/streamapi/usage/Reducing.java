package com.brianway.learning.java8.streamapi.usage;

import com.brianway.learning.java8.streamapi.Dish;
import static com.brianway.learning.java8.streamapi.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约
 */
public class Reducing {

    public static void main(String... args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, Integer::max);
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
