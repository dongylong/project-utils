package com.latte.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
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
    public static LocalDate queryLastDay(LocalDate localDate) {
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay;
    }
    public static LocalDate queryFirstDay(LocalDate localDate) {
        LocalDate firstDay = LocalDate.of(localDate.getYear(), localDate.getMonthValue(), 1);
        return firstDay;
    }
}
