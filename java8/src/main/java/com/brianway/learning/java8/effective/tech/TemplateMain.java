package com.brianway.learning.java8.effective.tech;

import java.util.function.Consumer;

/**
 * Created by brian on 17/3/24.
 * 模版方法
 */
public class TemplateMain {

    public static void main(String[] args) {
        // old school
        new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println("Hello " + c.getName());
            }
        }.processCustomer(1);

        // with lambdas
        new OnlineBankingLambda()
                .processCustomer(1, (Customer c) -> System.out.println("Hello " + c.getName()));

    }

    private static abstract class OnlineBanking {
        void processCustomer(int id) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy(c);
        }

        abstract void makeCustomerHappy(Customer c);

    }

    private static class OnlineBankingLambda {
        void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy.accept(c);
        }
    }

    // dummy Customer class
    static private class Customer {
        private int id = 1;
        private String name = "Brian";

        private String getName() {
            return name;
        }
    }

    // dummy Datbase class
    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }

}
