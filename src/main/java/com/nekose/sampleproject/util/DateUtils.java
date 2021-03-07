package com.nekose.sampleproject.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private DateUtils() {}

    public static String toIsoFormatString(Date date) {
        return DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }
}
