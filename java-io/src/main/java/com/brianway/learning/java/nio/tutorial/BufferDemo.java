package com.brianway.learning.java.nio.tutorial;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用Buffer的例子
 *
 * @auther brian
 * @since 2019/6/18 00:26
 */
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        String path = BufferDemo.class.getResource("/").getPath() + "buffer-demo.txt";
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            //make buffer ready for read
            buf.flip();
            while (buf.hasRemaining()) {
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }

            //make buffer ready for writing
            // System.out.println("------");
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
