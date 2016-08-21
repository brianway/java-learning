package com.brianway.learning.java.multithread.communication.example12;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by Brian on 2016/4/14.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write  :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
