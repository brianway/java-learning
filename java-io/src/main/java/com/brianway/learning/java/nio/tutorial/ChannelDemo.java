package com.brianway.learning.java.nio.tutorial;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 基本的 Channel 示例
 * 一个使用FileChannel读取数据到Buffer中的示例
 *
 * @auther brian
 * @since 2019/6/17 23:41
 */
public class ChannelDemo {
    public static void main(String[] args) {
        try {
            String path = ChannelDemo.class.getResource("/").getPath() + "channel-demo.txt";
            RandomAccessFile aFile = new RandomAccessFile(path, "rw");
            FileChannel inChannel = aFile.getChannel();
            // 该值小于文件内容的长度时，结果不同
            int bufferSize = 48;
            ByteBuffer buf = ByteBuffer.allocate(bufferSize);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {

                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
