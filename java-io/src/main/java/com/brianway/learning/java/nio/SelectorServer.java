package com.brianway.learning.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by caoqiwen on 2018/2/1.
 * nio的socket编程
 */
public class SelectorServer {
    private static int port = 1234;
    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ServerSocket serverSocket = ssc.socket();
            serverSocket.bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                //这里还是会阻塞。只是在处理请求的时候不会再需要通过多线程去处理数据而已。
                int n = selector.select();
                System.out.println(n);
                // System.out.println("查看你会不会阻塞");
                if (n == 0) continue;
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()) {
                        ServerSocketChannel ssc1 = (ServerSocketChannel) sk.channel();
                        SocketChannel sc = ssc1.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        readData(sk);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(SelectionKey key) {
        SocketChannel sc = (SocketChannel) key.channel();
        buffer.clear();
        try {
            int n=sc.read(buffer);
          //  System.out.println(n);
            while (sc.read(buffer) > 0) {   //这里一直会去读通道的值
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
