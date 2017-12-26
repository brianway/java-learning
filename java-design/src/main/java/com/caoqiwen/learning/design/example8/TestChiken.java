package com.caoqiwen.learning.design.example8;

/**
 * Created by caoqiwen on 2017/12/26.
 */
public class TestChiken {

    public static void main(String [] args){
//        Chicken chicken=new MiChicken(new ConChicken());
//        chicken.eatChicken();
//
//        Chicken chicken2=new TenCentChicken(new ConChicken());
//        chicken2.eatChicken();

        Chicken chicken1=new TenCentChicken(new MiChicken(new ConChicken()));
        chicken1.eatChicken();

    }
}
