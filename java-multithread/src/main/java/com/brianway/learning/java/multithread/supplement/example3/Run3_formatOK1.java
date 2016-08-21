package com.brianway.learning.java.multithread.supplement.example3;

/**
 * Created by Brian on 2016/4/17.
 */

import java.text.SimpleDateFormat;

/**
 * P295
 * SimpleDateFormat类非线程安全，解决异常方法一
 */
public class Run3_formatOK1 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[] {
                "2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05",
                "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"
        };
        Thread1[] threads = new Thread1[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread1(sdf, dateStringArray[i]);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

/*


 */