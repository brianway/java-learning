package com.brianway.learning.java8.streamapi;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流:从值序列,数组,文件来创建流
 * 斐波拉切数列的几种生成方法
 */
public class BuildingStreams {

    public static void main(String... args) throws Exception {

        /**
         * 由值创建流
         */
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        /**
         * 由数组创建流
         */
        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

        /**
         * 由函数生成流：创建无限流
         */
        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // fibonnaci with iterate
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(() -> 2)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        /**
         * 由文件生成流
         */
        String path = BuildingStreams.class.getResource("/").getPath() + "/data-building.txt";
        long uniqueWords = Files.lines(Paths.get(path), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println("There are " + uniqueWords + " unique words in data.txt");

    }
}
