package com.project.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class DateUtils {

    /**
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime dayStart(LocalDate localDate) {
        LocalDateTime time = LocalDateTime.of(localDate, LocalTime.MIN);
        return time;
    }

    /**
     *
     * @param localDate
     * @return
     */
    public static LocalDateTime dayEnd(LocalDate localDate) {
        LocalDateTime time = LocalDateTime.of(localDate, LocalTime.MAX);
        return time;
    }
}
