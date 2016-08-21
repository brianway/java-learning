package com.brianway.learning.java.multithread.supplement.example3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Brian on 2016/4/17.
 */
public class DateTools1 {
    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }

    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date).toString();
    }

}
