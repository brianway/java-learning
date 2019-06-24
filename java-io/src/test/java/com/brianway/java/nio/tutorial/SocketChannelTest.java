package com.brianway.java.nio.tutorial;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @auther brian
 * @since 2019/6/24 23:33
 */
public class SocketChannelTest {

    @Test
    public void testConnect() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        boolean connected = socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));
        Assert.assertEquals(true, connected);
        socketChannel.close();
    }

    @Test
    public void testNonBlocking() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connected = socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));
        System.out.println("connected: " + connected);
        while (!socketChannel.finishConnect()) {
            //wait, or do something else...
            System.out.println("not finish");
        }
        System.out.println("finished");
    }

}
