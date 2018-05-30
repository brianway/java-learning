package com.caoqiwen.learning.design.example5.MethodInterceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by caoqiwen on 2017/12/16.
 */
public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method invoke");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method invoke");
        return object;
    }
}
