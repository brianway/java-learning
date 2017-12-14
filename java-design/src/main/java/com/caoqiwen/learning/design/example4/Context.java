package com.caoqiwen.learning.design.example4;

/**
 * Created by caoqiwen on 2017/12/14.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.userStrategy();
    }
}
