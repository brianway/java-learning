package com.brianway.learning.java.nio.tutorial;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Full Selector Example
 * 启动后，浏览器输入 localhost:9999
 *
 * @auther brian
 * @since 2019/6/24 22:29
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        // SelectionKey key =
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            int readyChannels = selector.selectNow();

            if (readyChannels == 0) {
                // System.out.println("readyChannels == 0");
                continue;
            }

            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    System.out.println("accepted");
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println("connectable");
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    System.out.println("ready");
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                    System.out.println("writable");
                }

                keyIterator.remove();
            }
        }
    }
}
