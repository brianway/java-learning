package com.brianway.learning.java.base.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by caoqiwen on 2017/11/14.
 * cglib 测试用例
 */
public class CglibTest {

    public  static void main(String [] args){
        DaoProxy daoProxy=new DaoProxy();
        Enhancer enhancer = new Enhancer();
        DaoAnotherProxy daoAnotherProxy=new DaoAnotherProxy();
        DaoFilter daoFilter=new DaoFilter();
        enhancer.setSuperclass(DaoClass.class);
        enhancer.setCallbacks(new Callback[]{daoProxy,daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(daoFilter);
        DaoClass daoClass=(DaoClass)enhancer.create();
        daoClass.select();
        daoClass.update();
    }

}
