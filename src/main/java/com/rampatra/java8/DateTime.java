package com.rampatra.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author rampatra
 * @since 2019-05-15
 */
public class DateTime {

    private static long getCurrentTimestampFromInstant() {
        return Instant.now().toEpochMilli();
    }

    private static String addTwoDays() {
        LocalDateTime now = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"));
        LocalDateTime afterTwoDays = now.plusDays(2);
        return afterTwoDays.getDayOfMonth() + "-" + afterTwoDays.getMonthValue() + "-" + afterTwoDays.getYear();
    }

    public static void main(String[] args) {
        System.out.println("Timestamp from Instant: " + getCurrentTimestampFromInstant() +
                "\nTimestamp from Legacy Date: " + new Date().getTime());
        System.out.println("Add Two days: " + addTwoDays());
    }
}