package com.caoqiwen.learning.design.example8;

/**
 * Created by caoqiwen on 2017/12/26.
 */
public class TenCentChicken implements Chicken{
    private Chicken chicken;
    public TenCentChicken(Chicken chicken){
        super();
        this.chicken=chicken;
    }
    @Override
    public void eatChicken() {
        System.out.println("腾讯吃鸡游戏放点马化腾的广告");
        chicken.eatChicken();

    }
}
