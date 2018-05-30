package com.caoqiwen.learning.design.example2;

/**
 * Created by caoqiwen on 2017/12/13.
 * 有线程不安全的因素，会创建两个对象。
 */
public class LazySingleton {
    private static LazySingleton  instance=null;

    private LazySingleton(){

    }

    public  static  LazySingleton getInstance(){
        if (instance==null){
            instance=new LazySingleton();
        }
        return  instance;
    }
}
