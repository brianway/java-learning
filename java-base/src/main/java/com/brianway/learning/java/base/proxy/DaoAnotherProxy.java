package com.brianway.learning.java.base.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by caoqiwen on 2017/11/14.
 */
public class DaoAnotherProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
           System.out.println(method.getName()+":start time=["+System.currentTimeMillis()+"]");
           methodProxy.invokeSuper(o,objects);
           System.out.println(method.getName()+":end time=["+System.currentTimeMillis()+"]");
           return  o;
    }
}
