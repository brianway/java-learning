package com.brianway.learning.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by brian on 16/11/29.
 */
public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String parent = ChannelCopy.class.getResource("/").getPath();
        String infile = parent + "/infile.txt";
        String outCopy = parent + "/outCopy.txt";
        String outTransferTo = parent + "/outTransferTo.txt";
        copy(infile, outCopy);
        transferTo(infile, outTransferTo);
    }

    private static void copy(String infile, String outfile) throws IOException {
        FileChannel
                in = new FileInputStream(infile).getChannel(),
                out = new FileOutputStream(outfile).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip(); // prepare for writing
            out.write(buffer);
            buffer.clear(); // prepare for reading
        }
    }

    private static void transferTo(String infile, String outfile) throws IOException {
        FileChannel
                in = new FileInputStream(infile).getChannel(),
                out = new FileOutputStream(outfile).getChannel();
        in.transferTo(0, in.size(), out);
        // Or:
        // out.transferFrom(in,0,in.size());
    }
}
