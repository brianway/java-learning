package com.brianway.learning.java8.streamapi.collect;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.partitioningBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 得到 100 以内的质数和非质数
 *
 * - 分区:分类的特殊情况。分区函数返回一个布尔值
 * - Collector
 */
public class PartitionPrimeNumbers {

    public static void main(String... args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithCustomCollector(100));
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithInlineCollector(100));

    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(PartitionPrimeNumbers::isPrime));
    }

    /**
     * 判断一个数是不是质数
     */
    public static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, candidate - 1)
                .limit((long) Math.floor(Math.sqrt((double) candidate)) - 1)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    /**
     * 仅用质数作除数
     *
     * @param primes 部分结果
     * @param candidate 要判断的数
     * @return
     */
    public static boolean isPrime(List<Integer> primes, Integer candidate) {
        double candidateRoot = Math.sqrt((double) candidate);
        //return primes.stream().filter(p -> p < candidateRoot).noneMatch(p -> candidate % p == 0);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(i -> candidate % i == 0);
    }

    /**
     * 返回元素满足谓词的最长前缀
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    /**
     * Collector
     * 1.建立新的结果容器: supplier 方法
     * 2.将元素添到结果容器: accumulator 方法
     * 3.对容器应用最终转换: finisher 方法
     * 4.合并两个结果容器: combiner
     * 5.characteristics 方法
     */
    public static class PrimeNumbersCollector
            implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>() {{
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                acc.get(isPrime(acc.get(true), candidate))
                        .add(candidate);
            };
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return i -> i;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithInlineCollector(int n) {
        return Stream.iterate(2, i -> i + 1).limit(n)
                .collect(
                        () -> new HashMap<Boolean, List<Integer>>() {{
                            put(true, new ArrayList<>());
                            put(false, new ArrayList<>());
                        }},
                        (acc, candidate) ->
                                acc.get(isPrime(acc.get(true), candidate))
                                        .add(candidate)
                        ,
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });
    }
}
