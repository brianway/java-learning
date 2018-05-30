package com.brianway.learning.java.base.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by caoqiwen on 2017/11/14.
 */
public class DaoProxy  implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method invoke");
       methodProxy.invokeSuper(o,objects);
       // method.invoke(o,objects);
       // System.out.println(method.getName());
//        if ("select".equals(method.getName())){
//            return  0;
//        }
        System.out.println("after method invoke");
        return  o;
    }
}
