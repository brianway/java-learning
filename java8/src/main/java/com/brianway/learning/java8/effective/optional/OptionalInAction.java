package com.brianway.learning.java8.effective.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by brian on 17/3/27.
 * 使用 Optional 实战示例
 */
public class OptionalInAction {

    private static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        Optional<Object> value = getValue("key");
        System.out.println(value.orElse("this is null"));

        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("dd"));

    }

    /**
     * 用 Optional 封装可能为 null 的值
     */
    public static Optional<Object> getValue(String key) {
        Optional<Object> value = Optional.ofNullable(map.get(key));
        return value;
    }

    /**
     * 异常与 Optional 的对比
     */
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
