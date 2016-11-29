package com.brianway.learning.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by brian on 16/11/28.
 */
public class FileOutput {

    /**
     * 基本的文件输出
     */
    public static void basic(String infile, String outfile) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(infile)));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(outfile)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outfile));
    }

    /**
     * 文本文件输出的快捷方式
     */
    public static void shortcut(String infile, String outfile) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(infile)));
        PrintWriter out = new PrintWriter(outfile);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outfile));
    }

    public static void main(String[] args) throws IOException {
        String parent = FileOutput.class.getResource("/").getPath();
        String infile = parent + "/infile.txt";

        String outfile = parent + "/BasicOut";
        basic(infile, outfile);

        outfile = parent + "ShortcutOut";
        shortcut(infile, outfile);
    }
}
