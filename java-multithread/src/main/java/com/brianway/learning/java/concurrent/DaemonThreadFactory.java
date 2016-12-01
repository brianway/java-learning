package com.brianway.learning.java.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created by brian on 16/12/1.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
