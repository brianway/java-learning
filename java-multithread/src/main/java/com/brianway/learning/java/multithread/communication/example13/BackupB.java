package com.brianway.learning.java.multithread.communication.example13;

/**
 * Created by Brian on 2016/4/14.
 */
public class BackupB extends Thread {
    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
