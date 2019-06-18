package com.brianway.java.nio.tutorial;

import com.brianway.learning.java.nio.tutorial.BufferDemo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 通道之间的数据传输
 *
 * @auther brian
 * @since 2019/6/19 00:20
 */
public class ChannelTransferTest {
    private String fromPath = BufferDemo.class.getResource("/").getPath() + "fromFile.txt";
    private String toPath = BufferDemo.class.getResource("/").getPath() + "toFile.txt";

    @Test
    public void testTransferFrom() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(fromPath, "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            long transferBytesSize =
                    toChannel.transferFrom(fromChannel, position, count);
            Assert.assertEquals(26, transferBytesSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTransferTo() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(fromPath, "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            long transferBytesSize =
                    fromChannel.transferTo(position, count, toChannel);
            Assert.assertEquals(26, transferBytesSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
