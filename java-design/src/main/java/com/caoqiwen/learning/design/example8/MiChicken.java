package com.caoqiwen.learning.design.example8;

/**
 * Created by caoqiwen on 2017/12/26.
 */
public class MiChicken  implements  Chicken{

    private Chicken chicken;
    public  MiChicken(Chicken chicken){
        super();
        this.chicken=chicken;
    }
    @Override
    public void eatChicken() {
        System.out.println("小米吃鸡游戏放点小米官网的广告");
        chicken.eatChicken();

    }
}
