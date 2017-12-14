package com.caoqiwen.learning.design.example4;

/**
 * Created by caoqiwen on 2017/12/14.
 */
public class TestStrategy {

    public static void main(String[] args) {
        StrategyA strategyA = new StrategyA();
        StrategyB strategyB = new StrategyB();
        Context context = new Context(strategyA);
        context.strategyMethod();
        context = new Context(strategyB);
        context.strategyMethod();
    }

}
