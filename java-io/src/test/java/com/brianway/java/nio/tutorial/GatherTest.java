package com.brianway.java.nio.tutorial;

import com.brianway.learning.java.nio.tutorial.BufferDemo;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @auther brian
 * @since 2019/6/18 23:51
 */
public class GatherTest {

    private String path = BufferDemo.class.getResource("/").getPath() + "gather.txt";

    @Test
    public void testGatheringWrites() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        header.put("这是头".getBytes(Charset.forName("UTF-8")));
        body.put("this is body.".getBytes(Charset.forName("UTF-8")));
        header.flip();
        body.flip();
        //write data into buffers
        ByteBuffer[] bufferArray = {header, body};
        // 注意只有position和limit之间的数据才会被写入
        channel.write(bufferArray);
        channel.close();
    }
}
