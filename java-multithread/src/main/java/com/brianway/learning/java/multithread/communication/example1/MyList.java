package com.brianway.learning.java.multithread.communication.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 2016/4/13.
 */
public class MyList {
    private List list = new ArrayList();

    public void add() {
        list.add("brian");
    }

    public int size() {
        return list.size();
    }
}

