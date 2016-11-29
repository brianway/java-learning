package com.brianway.learning.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by brian on 16/11/29.
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String parent = GetChannel.class.getResource("/").getPath();
        String filename = parent + "/data.txt";
        write(filename);
        addToEnd(filename);
        read(filename);
    }

    private static void write(String filename) throws IOException {
        FileChannel fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
    }

    private static void addToEnd(String filename) throws IOException {
        FileChannel fc = new RandomAccessFile(filename, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();
    }

    private static void read(String filename) throws IOException {
        FileChannel fc = new FileInputStream(filename).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
        fc.close();
    }
}
