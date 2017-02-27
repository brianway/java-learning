package com.brianway.learning.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lambda实践: 环绕执行模式
 * 1. 行为参数化
 * 2. 使用函数式接口来传递行为
 * 3. 执行一个行为
 * 4. 传递 Lambda
 */
public class ExecuteAround {

    private static final String RESOURCE_ROOT = ExecuteAround.class
            .getResource("/").getPath() + "/data-lambda.txt";

    public static void main(String... args) throws IOException {

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile(BufferedReader::readLine);
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(RESOURCE_ROOT))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(RESOURCE_ROOT))) {
            return p.process(br);
        }

    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;

    }
}
