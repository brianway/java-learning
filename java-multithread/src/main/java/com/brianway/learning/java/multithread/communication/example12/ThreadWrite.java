package com.brianway.learning.java.multithread.communication.example12;

import java.io.PipedOutputStream;

/**
 * Created by Brian on 2016/4/14.
 */
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
