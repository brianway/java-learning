package com.brianway.learning.java.multithread.synchronize.example15;

/**
 * Created by Brian on 2016/4/13.
 */
public class RunThread extends Thread {
    private boolean isRunning = true;
    //volatile private boolean isRunning  = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {

        }
        System.out.println("线程被停止了");
    }
}
