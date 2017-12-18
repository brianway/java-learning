package com.caoqiwen.learning.design.example5;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by caoqiwen on 2017/12/15.
 * 模拟Ngix反向代理
 */
public class NgixProxy implements Server {

    private static final List<String> WY_SERVER_ADDRESS = new ArrayList<String>() {{
        add("192.168.0.1");
        add("192.168.0.2");
        add("192.168.0.3");
    }};

    public  NgixProxy(Server server){
        this.server=server;
    }

    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String getPageTitle(String url) {
        String remoteIP = UUID.randomUUID().toString();
        int index = Math.abs(remoteIP.hashCode()) % WY_SERVER_ADDRESS.size();
        String realIP = WY_SERVER_ADDRESS.get(index);
        return "网站" + server.getPageTitle(url) + "[来源ip" + realIP + "]";
    }
}
