package com.brianway.learning.java8.effective.tech;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class ObserverMain {

    public static void main(String[] args) {
        //old school
        Subject f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

        // with lambdas
        Feed feedLambda = new Feed();

        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        feedLambda.notifyObservers("Money money money, give me money!");

    }

    interface Observer {
        void inform(String tweet);
    }

    interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    static private class NYTimes implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY!" + tweet);
            }
        }
    }

    static private class Guardian implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        }
    }

    static private class LeMonde implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    static private class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer o) {
            this.observers.add(o);
        }

        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.inform(tweet));
        }
    }

}
