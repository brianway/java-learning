package com.brianway.learning.java.multithread.supplement.example3;

import java.text.SimpleDateFormat;

/**
 * Created by Brian on 2016/4/17.
 */
public class DateTools2 {
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        SimpleDateFormat sdf = null;
        sdf = tl.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(datePattern);
            tl.set(sdf);
        }
        return sdf;
    }

}
