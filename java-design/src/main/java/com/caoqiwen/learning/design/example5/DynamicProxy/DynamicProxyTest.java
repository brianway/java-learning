package com.caoqiwen.learning.design.example5.DynamicProxy;

import com.caoqiwen.learning.design.example5.Server;
import com.caoqiwen.learning.design.example5.WYServer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by caoqiwen on 2017/12/15.
 */
public class DynamicProxyTest {
    public static void main(String []args) {
        Server wyServer = new WYServer();
        InvocationHandler invocationHandler = new NginxInvocationHandler(wyServer);
        Server server = (Server) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), new Class[]{Server.class}, invocationHandler);
        System.out.println(server.getPageTitle("http://www.163.com/"));
    }
}
