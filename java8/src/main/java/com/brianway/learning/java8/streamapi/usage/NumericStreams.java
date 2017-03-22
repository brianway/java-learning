package com.brianway.learning.java8.streamapi.usage;

import com.brianway.learning.java8.streamapi.Dish;
import static com.brianway.learning.java8.streamapi.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数值流
 * 原始类型特化
 * 数值范围
 */
public class NumericStreams {

    public static void main(String... args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:" + calories);

        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);

        // 直接使用 orElse
        System.out.print("使用 orElse: ");
        System.out.println(maxCalories.orElse(1));

        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());

        // 勾股数
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> isPerfectSquare(a * a + b * b))
                                .boxed()
                                .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
                        );

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

}
