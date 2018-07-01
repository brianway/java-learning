package com.caoqiwen.learning.design.example5.MethodInterceptor;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by caoqiwen on 2017/12/17.
 */
public class testCglib {

    public static void main(String[] args) {
        System.out.println("hello world");
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);
        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();
    }
}
