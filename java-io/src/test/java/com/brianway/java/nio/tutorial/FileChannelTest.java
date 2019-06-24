package com.brianway.java.nio.tutorial;

import com.brianway.learning.java.nio.tutorial.BufferDemo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * FileChannel测试
 *
 * @auther brian
 * @since 2019/6/24 23:00
 */
public class FileChannelTest {
    private String dir = BufferDemo.class.getResource("/").getPath();
    private String path = BufferDemo.class.getResource("/").getPath() + "fileChannel.txt";

    @Test
    public void testTruncate() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(dir + "truncate.txt", "rw");
        FileChannel channel = aFile.getChannel();
        int size = 10;
        //  Truncates this channel's file to the given size.
        channel.truncate(size);
        long fileSize = channel.size();
        Assert.assertEquals(size, fileSize);
    }
}
