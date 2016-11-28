package com.brianway.learning.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by brian on 16/11/28.
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String file = BufferedInputFile.class.getResource("/").getPath()
                + "/infile.txt";
        System.out.print(read(file));
    }
}
