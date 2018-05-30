package com.caoqiwen.learning.design.example7;

/**
 * Created by caoqiwen on 2017/12/22.
 * 外观模式
 */
public class Facade {
    private ModuleA moduleA = null;
    private ModuleB moduleB = null;
    private ModuleC moduleC = null;

    public Facade() {
        moduleA = new ModuleA();
        moduleB = new ModuleB();
        moduleC = new ModuleC();
    }
    public void test(){
        moduleA.testModuleA();
        moduleB.testModuleB();
        moduleC.testModuleC();
    }


    public static void main(String[] args){
        Facade facade=new Facade();
        facade.test();
    }
}