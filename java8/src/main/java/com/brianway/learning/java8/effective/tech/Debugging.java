package com.brianway.learning.java8.effective.tech;

import java.util.Arrays;
import java.util.List;

/**
 * 查看栈跟踪
 */
public class Debugging {
    public static void main(String[] args) {
//        Arrays.asList(1, 2, 3).stream()
//                .map(Debugging::divideByZero)
//                .forEach(System.out::println);

        List<Point> points = Arrays.asList(new Point(12, 2), null);
        //points.stream().map(p -> p.getX()).forEach(System.out::println);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    public static int divideByZero(int n) {
        return n / 0;
    }
}
