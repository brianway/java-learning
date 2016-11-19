package com.brianway.learning.java.base;

/**
 * Created by brian on 16/11/10.
 *
 * TODO 补码/反码相关知识
 * https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/ComputerCode.html
 * http://weihe6666.iteye.com/blog/1190033
 *
 * 在计算机中，负数以原码的补码形式表达。
 */
public class Binary {
    public static void main(String[] args) {
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);

        int[] arr = new int[] {3, -2};
        for (int a : arr) {
            //原数
            System.out.println("a:" + a + "  二进制:" + Integer.toBinaryString(a));
            // 按位取反
            System.out.println("~a:" + ~a + "  二进制:" + Integer.toBinaryString(~a));
            // 相反数
            System.out.println("-a:" + -a + "  二进制:" + Integer.toBinaryString(-a));

            System.out.println(-a == ~a + 1);
            System.out.println(~a == -a - 1);
        }

    }
}
