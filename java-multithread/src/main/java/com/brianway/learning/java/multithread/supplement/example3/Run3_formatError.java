package com.brianway.learning.java.multithread.supplement.example3;

/**
 * Created by Brian on 2016/4/17.
 */

import java.text.SimpleDateFormat;

/**
 * P293
 * SimpleDateFormat类非线程安全
 * 有时正常运行，有时报异常
 */
public class Run3_formatError {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[] {
                "2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05",
                "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"
        };
        Thread0[] threads = new Thread0[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread0(sdf, dateStringArray[i]);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

/*
ThreadName = Thread-6报错了 日期字符串：2000-01-07 转换成的日期为1999-12-02
ThreadName = Thread-4报错了 日期字符串：2000-01-05 转换成的日期为2000-01-09
ThreadName = Thread-1报错了 日期字符串：2000-01-02 转换成的日期为1999-12-02
ThreadName = Thread-0报错了 日期字符串：2000-01-01 转换成的日期为2000-01-05
ThreadName = Thread-5报错了 日期字符串：2000-01-06 转换成的日期为1999-12-03
Exception in thread "Thread-3" java.lang.NumberFormatException: For input string: ""
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Long.parseLong(Long.java:601)
	at java.lang.Long.parseLong(Long.java:631)
	at java.text.DigitList.getLong(DigitList.java:195)
	at java.text.DecimalFormat.parse(DecimalFormat.java:2051)
	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
	at java.text.DateFormat.parse(DateFormat.java:364)
	at com.brianway.learning.java.multithread.supplement.example3.Thread0.run(Thread0.java:22)

 */