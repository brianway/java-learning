package com.brianway.learning.java8.effective.tech;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 工厂模式
 */
public class FactoryMain {

    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");
        p1.printClassName();

        // with lambdas
        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();
        p2.printClassName();

        Product p3 = ProductFactory.createProductLambda("loan");
        p3.printClassName();
    }

    static private class ProductFactory {
        public static Product createProduct(String name) {
            switch (name) {
                case "loan":
                    return new Loan();
                case "stock":
                    return new Stock();
                case "bond":
                    return new Bond();
                default:
                    throw new RuntimeException("No such product " + name);
            }
        }

        public static Product createProductLambda(String name) {
            Supplier<Product> p = map.get(name);
            if (p != null) return p.get();
            throw new RuntimeException("No such product " + name);
        }
    }

    private interface Product {
        default void printClassName() {
            System.out.println(getClass().getSimpleName());
        }
    }

    static private class Loan implements Product {
    }

    static private class Stock implements Product {
    }

    static private class Bond implements Product {
    }

    final static private Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
}
