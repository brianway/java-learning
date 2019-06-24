package com.brianway.java.nio.tutorial;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @auther brian
 * @since 2019/6/25 00:31
 */
public class ServerSocketChannelTest {

    @Test
    public void testOpen() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while (true) {
            System.out.println("waiting...");
            SocketChannel socketChannel =
                    serverSocketChannel.accept();
            //do something with socketChannel...
            System.out.println("connected: " + socketChannel.toString());
        }
    }

    @Test
    public void testNonBlocking() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            System.out.println("waiting...");
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            if (socketChannel != null) {
                //do something with socketChannel...
                System.out.println("connected: " + socketChannel.toString());
            }
        }
    }

}
