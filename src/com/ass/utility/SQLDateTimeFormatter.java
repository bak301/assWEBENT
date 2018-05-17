package com.ass.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public final class SQLDateTimeFormatter {
    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDateTime time) {
        return fmt.format(time);
    }
}
