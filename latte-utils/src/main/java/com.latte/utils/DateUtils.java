//package com.latte.utils;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneOffset;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;
//import java.time.format.SignStyle;
//import java.time.temporal.TemporalAdjusters;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//import static java.time.temporal.ChronoField.*;
//import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
//
//public class DateUtils {
//
//    /**
//     *
//     * @param localDate
//     * @return
//     */
//    public static LocalDateTime dayStart(LocalDate localDate) {
//        LocalDateTime time = LocalDateTime.of(localDate, LocalTime.MIN);
//        return time;
//    }
//
//    /**
//     *
//     * @param localDate
//     * @return
//     */
//    public static LocalDateTime dayEnd(LocalDate localDate) {
//        LocalDateTime time = LocalDateTime.of(localDate, LocalTime.MAX);
//        return time;
//    }
//    public static LocalDate queryLastDay(LocalDate localDate) {
//        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
//        return lastDay;
//    }
//    public static LocalDate queryFirstDay(LocalDate localDate) {
//        LocalDate firstDay = LocalDate.of(localDate.getYear(), localDate.getMonthValue(), 1);
//        return firstDay;
//    }
//
//
//
//
//
//    public static final String DATE_FORMAT = "yyyy-MM-dd";
//    public static final String MONTH_STRING = "月";
//    public static final String DAY_STRING = "日";
//
//    /**
//     * 跨天的时间展示
//     *
//     * @param earliestBeginTime
//     * @param latestEndTime
//     * @return 2019-09-25 00:00-23:00
//     */
//    public static String assembleMultiDayTime(LocalDateTime earliestBeginTime, LocalDateTime latestEndTime) {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(assembleMonthAndDay(earliestBeginTime))
//                .append(CharacterUtils.HYPHEN_DELIMITER)
//                .append(assembleMonthAndDay(latestEndTime));
//        return buffer.toString();
//    }
//
//    public static StringBuilder assembleMonthAndDay(LocalDateTime time) {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(time.getMonthValue())
//                .append(MONTH_STRING)
//                .append(time.getDayOfMonth())
//                .append(DAY_STRING);
//        return buffer;
//    }
//
//    /**
//     * @param time
//     * @return 9月6日 15:32
//     */
//    public static StringBuilder assembleMonthAndDayTimeBuilder(LocalDateTime time) {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(time.getMonthValue())
//                .append(MONTH_STRING)
//                .append(time.getDayOfMonth())
//                .append(DAY_STRING)
//                .append(CharacterUtils.SPACE_DELIMITER)
//                .append(time.format(generateTimeFormatter()));
//        return buffer;
//    }
//
//    /**
//     * @param time
//     * @return 9月6日 15:32:01
//     * 秒为00：9月6日 15:32
//     */
//    public static StringBuilder assembleMonthAndLocalTimeBuilder(LocalDateTime time) {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(time.getMonthValue())
//                .append(MONTH_STRING)
//                .append(time.getDayOfMonth())
//                .append(DAY_STRING)
//                .append(CharacterUtils.SPACE_DELIMITER)
//                .append(time.toLocalTime());
//        return buffer;
//    }
//
//    /**
//     * @param time
//     * @return 9月6日 15:32:00
//     */
//    public static String assembleMonthAndDayTime(LocalDateTime time) {
//        return assembleMonthAndDayTimeBuilder(time).toString();
//    }
//
//    /**
//     * @param time
//     * @return yyyy-mm-dd hh:mi:ss
//     */
//    public static String assembleDateAndTime(LocalDateTime time) {
//        return time.format(generateDateTimeFormatter());
//    }
//    public static LocalDateTime assembleDateAndTime(String time) {
//        if(StringUtils.isBlank(time)){
//            return null;
//        }
//        return LocalDateTime.parse(time, generateDateTimeFormatter());
//
//    }
//
//    /**
//     * 当天的时间展示
//     *
//     * @param earliestBeginTime
//     * @param latestEndTime
//     * @return 2019-09-25 00:00-23:00
//     */
//    public static String assembleCurrentDayTime(LocalDateTime earliestBeginTime, LocalDateTime latestEndTime) {
//        StringBuilder buffer = new StringBuilder();
//        buffer.append(assembleMonthAndDay(earliestBeginTime))
//                .append(CharacterUtils.SPACE_DELIMITER)
//                .append(earliestBeginTime.format(generateTimeFormatter()))
//                .append(CharacterUtils.HYPHEN_DELIMITER)
//                .append(latestEndTime.format(generateTimeFormatter()));
//        return buffer.toString();
//    }
//
//    /**
//     * 当天的时间展示
//     *
//     * @param beginTime
//     * @param endTime
//     * @return 2019-09-25 00:00-23:00
//     */
//    public static String assembleDayTime(LocalDateTime beginTime, LocalDateTime endTime) {
//        String str;
//        if (beginTime.toLocalDate().equals(endTime.toLocalDate())) {
//            str = assembleCurrentDayTime(beginTime, endTime);
//        } else {
//            str = assembleMultiDayTime(beginTime, endTime);
//        }
//        return str;
//    }
//
//    /**
//     * @return yyyy-mm-dd hh:mi:ss
//     */
//    public static DateTimeFormatter generateDateTimeFormatter() {
//        DateTimeFormatterBuilder dataTimeBuilder = new DateTimeFormatterBuilder()
//                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
//                .appendLiteral(CharacterUtils.HYPHEN_DELIMITER)
//                .appendValue(MONTH_OF_YEAR, 2)
//                .appendLiteral(CharacterUtils.HYPHEN_DELIMITER)
//                .appendValue(DAY_OF_MONTH, 2)
//                .appendLiteral(CharacterUtils.SPACE_DELIMITER)
//                .appendValue(HOUR_OF_DAY, 2)
//                .appendLiteral(CharacterUtils.COLON_DELIMITER)
//                .appendValue(MINUTE_OF_HOUR, 2)
//                .optionalStart()
//                .appendLiteral(CharacterUtils.COLON_DELIMITER)
//                .appendValue(SECOND_OF_MINUTE, 2);
//        return dataTimeBuilder.toFormatter();
//    }
//
//    public static DateTimeFormatter generateTimeFormatter() {
//        DateTimeFormatterBuilder dataTimeBuilder = new DateTimeFormatterBuilder()
//                .appendValue(HOUR_OF_DAY, 2)
//                .appendLiteral(CharacterUtils.COLON_DELIMITER)
//                .appendValue(MINUTE_OF_HOUR, 2)
//                .optionalStart();
//        return dataTimeBuilder.toFormatter();
//    }
//
//
//    /**
//     * @param time 2019-11-06T16:10
//     *             currentTime : 2019-11-06T18:00:21.884
//     * @return 判断时间是否在当前时间之后 false
//     */
//    public static boolean verifyAfterCurrentTime(LocalDateTime time) {
//        return !verifyBeforeCurrentTime(time);
//    }
//
//    /**
//     * @param time time : 2019-11-06T16:10
//     *             currentTime : 2019-11-06T18:00:21.884
//     * @return 判断时间是否在当前时间之前 true
//     */
//    public static boolean verifyBeforeCurrentTime(LocalDateTime time) {
//        LocalDateTime now = getRequestTime();
//        return time.isBefore(now);
//    }
//
//    /**
//     * 字符串时间戳转换为LocalDateTime
//     */
//    public static LocalDateTime string2LocalDateTime(String timeStr) {
//        LocalDateTime localDateTime = new Date(Long.valueOf(timeStr)).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
//        return localDateTime;
//    }
//
//    public static Long localDateTime2Long(LocalDateTime timeStr) {
//        Long second = timeStr.toEpochSecond(ZoneOffset.of("+8"));
//        return second;
//    }
//
//    /**
//     * 展示格式 2019.09.27
//     */
//    public static String assembleYearAndMonthAndDay(LocalDateTime time) {
//        return time.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
//    }
//
//    public static LocalDateTime getRequestTime() {
//        Long requestTime = getRequestTimeLong();
//        if (requestTime == null) {
//            return LocalDateTime.now();
//        }
//        return DateUtil.long2DateTime(requestTime);
//    }
//
//    public static Long getRequestTimeLong() {
//        Long requestTime;
//        boolean env = "master".equalsIgnoreCase(Util.runEvn);
//        String timestamp = StringUtil.EMPTY;
//        if (Objects.nonNull(RequestData.getRequest())) {
//            timestamp = RequestData.getRequest().getHeader("timestamp");
//        }
//
//        try {
//            if (StringUtil.isNotEmpty(timestamp) && !env) {
//                requestTime = Long.valueOf(timestamp);
//            } else {
//                requestTime = RequestData.getRequestTime();
//            }
//        } catch (Exception e) {
//            requestTime = System.currentTimeMillis();
//        }
//        return requestTime;
//    }
//
//    //获取时分
//    public static String getMinuteAndSecond(LocalDateTime time) {
//        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
//    }
//
//    public static LocalDateTime getMinCurrentDate(LocalDateTime time) {
//        return LocalDateTime.of(time.toLocalDate(), LocalTime.of(0,0,0));
//    }
//
//    public static LocalDateTime getMaxCurrentDate(LocalDateTime time) {
//        return LocalDateTime.of(time.toLocalDate(), LocalTime.of(23,59,59));
//    }
//
//}
