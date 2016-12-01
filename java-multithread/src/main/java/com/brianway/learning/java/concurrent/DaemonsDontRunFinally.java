package com.brianway.learning.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Daemon threads don't run the finally clause
 *
 * output:"Starting ADaemon" or nothing
 */

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}
/* Output:
Starting ADaemon

or

output nothing
*///:~
