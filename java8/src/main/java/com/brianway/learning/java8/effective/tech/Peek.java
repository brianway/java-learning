package com.brianway.learning.java8.effective.tech;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

/**
 * 使用日志调试
 */
public class Peek {

    public static void main(String[] args) {

        List<Integer> result = Stream.of(2, 3, 4, 5)
                .peek(x -> System.out.println("taking from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(toList());
    }
}
