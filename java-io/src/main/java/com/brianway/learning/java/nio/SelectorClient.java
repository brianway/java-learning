package com.brianway.learning.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by caoqiwen on 2018/2/1.
 */
public class SelectorClient {

    private static String str = "hello world";
    private static final int port = 1234;
    private static final String ip = "127.0.0.1";
    private static final int thread_count = 5;

    private static class NonBlockingClient extends Thread {
        @Override
        public void run() {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                socketChannel.connect(new InetSocketAddress(ip, port));
                while (!socketChannel.finishConnect()) {
                    System.out.println("同" + ip + "的连接正在建立，请稍等！");
                    Thread.sleep(10);
                }
                System.out.println("连接已经建立到ip+端口！，时间为:" + System.currentTimeMillis());
                String writeStr = str + this.getName();
                ByteBuffer buffer = ByteBuffer.allocate(writeStr.length());
                buffer.put(writeStr.getBytes());
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
                socketChannel.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NonBlockingClient[] nbts = new NonBlockingClient[thread_count];
        for (int i = 0; i < thread_count; i++) {
            nbts[i] = new NonBlockingClient();
        }
        for (int i = 0; i < thread_count; i++) {
            nbts[i].start();
        }
        for (int i = 0; i < thread_count; i++) {
            nbts[i].join();
        }
    }
}
