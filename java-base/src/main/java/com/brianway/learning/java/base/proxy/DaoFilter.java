package com.brianway.learning.java.base.proxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by caoqiwen on 2017/11/14.
 */
public class DaoFilter   implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())){
            return 1;
        }
            return  0;
    }
}
