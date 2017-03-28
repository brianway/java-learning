package com.brianway.learning.java8.effective.async;

import static com.brianway.learning.java8.effective.async.Util.delay;
import static com.brianway.learning.java8.effective.async.Util.format;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * 使用工厂方法 supplyAsync 创建 CompletableFuture
 */
public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPrice(String product) {
/*      // 抛出 CompletableFuture 内的异常
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
                    try {
                        double price = calculatePrice(product);
                        futurePrice.complete(price);
                    } catch (Exception ex) {
                        futurePrice.completeExceptionally(ex);
                    }
        }).start();
        return futurePrice;
*/
        // 使用工厂方法
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        if (true) {
            throw new RuntimeException("product not available");
        }
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

}