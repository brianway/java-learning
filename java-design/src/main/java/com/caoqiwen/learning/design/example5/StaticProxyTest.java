package com.caoqiwen.learning.design.example5;

/**
 * Created by caoqiwen on 2017/12/15.
 */
public class StaticProxyTest {
    public  static void main(String [] args){
        Server wyProxyserver=new WYServer();
        Server nigxServer=new NgixProxy(wyProxyserver);
        System.out.println(nigxServer.getPageTitle("http://www.163.com/"));
    }
}
