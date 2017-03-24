package com.brianway.learning.java8.streamapi.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行流计算 1~n 的和
 * 分别使用指令式,串行迭代流,并行迭代流,基本类型流,有副作用的流
 */
public class ParallelStreams {

    /**
     * for 循环的迭代
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    /**
     * iterate 的问题:
     * - iterate 生成的是装箱的对象,必须拆成数字才能求和
     * - 很难把 iterate 分成多个独立块来并行执行
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    /**
     * 使用 LongStream.rangeClosed
     * - 没有装箱拆箱
     * - 容易拆分为独立的小块
     */
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    /**
     * 共享了可变状态,导致每次结果不一致
     */
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
