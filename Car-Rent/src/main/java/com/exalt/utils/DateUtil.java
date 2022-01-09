package com.exalt.utils;

import java.text.SimpleDateFormat;

public class DateUtil {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String getTimeStamp() {
        return dateFormat.format(System.currentTimeMillis());
    }
}
