package com.brianway.learning.java8.effective.async;

import static com.brianway.learning.java8.effective.async.Util.delay;
import static com.brianway.learning.java8.effective.async.Util.format;

import java.util.Random;

/**
 * 商店类
 * 报价按照 `name:price:code` 的格式
 */
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
