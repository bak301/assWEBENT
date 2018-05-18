package com.ass.utility;

import java.time.LocalDateTime;

public final class SQLDateTimeFormatter {

    public static String format(LocalDateTime time) {
        return time.toString().replace('T', ' ');
    }
}
