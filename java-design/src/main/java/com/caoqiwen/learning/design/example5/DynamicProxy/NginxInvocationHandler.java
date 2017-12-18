package com.caoqiwen.learning.design.example5.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by caoqiwen on 2017/12/15.
 */
public class NginxInvocationHandler  implements InvocationHandler{
    private static final List<String> WY_SERVER_ADDRESS = new ArrayList<String>() {{
        add("192.168.0.1");
        add("192.168.0.2");
        add("192.168.0.3");
    }};
    private  Object object;

    public NginxInvocationHandler(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String remoteIP= UUID.randomUUID().toString();
        int index = Math.abs(remoteIP.hashCode()) % WY_SERVER_ADDRESS.size();
        String realIP = WY_SERVER_ADDRESS.get(index);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("页面标题:");
        stringBuffer.append(method.invoke(object,args));
        stringBuffer.append("[来源地址]:");
        stringBuffer.append(realIP);
        return stringBuffer.toString();
    }
}
