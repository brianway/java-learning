package com.brianway.learning.java.multithread.communication.example12;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Brian on 2016/4/14.
 */
public class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read   :");
            byte[] bytes = new byte[20];
            int readLength = input.read(bytes);
            while (readLength != -1) {
                String newData = new String(bytes, 0, readLength);
                System.out.print(newData);
                readLength = input.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
