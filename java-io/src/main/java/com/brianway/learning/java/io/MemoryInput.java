package com.brianway.learning.java.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by brian on 16/11/28.
 * 内存输入
 */

public class MemoryInput {

    /**
     * 从内存输入
     */
    public static void useStringReader(String filename) {
        try {
            StringReader in = new StringReader(
                    BufferedInputFile.read(filename));
            int c;
            while ((c = in.read()) != -1)
                System.out.print((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 格式化的内存输入
     */
    public static void readFormattedInput(String filename) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(filename)
                                    .getBytes()));
            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
            throws IOException {
        String filename = MemoryInput.class.getResource("/").getPath()
                + "/infile.txt";
        useStringReader(filename);
        readFormattedInput(filename);
    }
}
