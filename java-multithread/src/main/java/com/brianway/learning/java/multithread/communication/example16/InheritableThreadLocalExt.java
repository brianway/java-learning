package com.brianway.learning.java.multithread.communication.example16;

import java.util.Date;

/**
 * Created by Brian on 2016/4/14.
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
