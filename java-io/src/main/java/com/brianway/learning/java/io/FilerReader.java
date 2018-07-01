package com.brianway.learning.java.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by caoqiwen on 2017/11/8.
 */

/**
 * 字符流的读取
 */
public class FilerReader {

    public  static void main(String[] args){
       // System.out.println("caoqiwen");
        String parent=FilerReader.class.getResource("/").getPath();
        String infile = parent + "/infile.txt";
        try {
            basicRead(infile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void basicRead(String file) throws IOException {
        FileReader reader=new FileReader(file);
        char[] buf=new char[1024];
        while (reader.read(buf)!=-1){
            System.out.print(new String(buf,0,buf.length));
        }
    }
}
