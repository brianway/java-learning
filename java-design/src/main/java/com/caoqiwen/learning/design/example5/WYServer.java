package com.caoqiwen.learning.design.example5;

/**
 * Created by caoqiwen on 2017/12/15.
 */
public class WYServer implements Server {
    @Override
    public String getPageTitle(String url) {
        if ("http://www.163.com/".equals(url)) {
            return "网易首页";
        }
        return "无网站首页";
    }
}
