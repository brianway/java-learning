package com.brianway.learning.java8.streamapi.collect;

import com.brianway.learning.java8.streamapi.Dish;
import static com.brianway.learning.java8.streamapi.Dish.menu;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

/**
 * 归约和汇总
 */
public class Summarizing {

    public static void main(String... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    /**
     * 统计个数
     */
    private static long howManyDishes() {
        return menu.stream().collect(counting());
    }

    /**
     * 查找流中最大值
     */
    private static Dish findMostCaloricDish() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    /**
     * 查找流中最大值
     */
    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(reducing(moreCaloricOf)).get();
    }

    /**
     * 汇总-求和
     */
    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    /**
     * 汇总-求平均数
     */
    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    /**
     * 汇总-统计值
     */
    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    /**
     * 连接字符串
     */
    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
