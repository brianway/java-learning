package com.brianway.learning.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by brian on 16/11/28.
 *
 * 从标准输入中读取,并将 System.out 转换成 PrintWriter
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);// 开启自动清空

        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            //System.out.println(s);
            out.println(s);
        }
    }
}
