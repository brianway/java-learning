package com.brianway.learning.java.multithread.communication.example12;

import java.io.PipedInputStream;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.input = input;
        this.read = read;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
