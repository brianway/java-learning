package com.brianway.java.nio.tutorial;

import com.brianway.learning.java.nio.tutorial.BufferDemo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @auther brian
 * @since 2019/6/18 23:24
 */
public class ScatterTest {

    private String path = BufferDemo.class.getResource("/").getPath() + "scatter.txt";

    @Test
    public void testScatteringReads() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel fc = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer header = ByteBuffer.allocate(8);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};
        long bytesRead = fc.read(bufferArray);
        // System.out.println(bytesRead);
        Assert.assertEquals(26, bytesRead);
        //print header
        System.out.println("---header(" + header.limit() + "bytes)---");
        header.flip();
        while (header.hasRemaining()) {
            // read 1 byte at a time
            System.out.print((char) header.get());
        }
        header.clear();

        // print body
        body.flip();
        System.out.println("---body(" + body.limit() + "bytes)----");
        while (body.hasRemaining()) {
            // read 1 byte at a time
            System.out.print((char) body.get());
        }
        header.clear();
        body.clear();
        fc.close();
    }
}
