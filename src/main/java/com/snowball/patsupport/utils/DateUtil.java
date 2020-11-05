package com.snowball.patsupport.utils;

import com.snowball.patsupport.entity.Perso;

import java.util.Calendar;

public class DateUtil {

    public static final long ONE_MINUTE_TIMESTAMP = 60 * 1000L;
    public static final long ONE_HOUR_TIMESTAMP = 60 * ONE_MINUTE_TIMESTAMP;
    public static final long ONE_DAY_TIMESTAMP = 24 * ONE_HOUR_TIMESTAMP;
    public static final long ONE_WEEK_TIMESTAMP = 7 * ONE_DAY_TIMESTAMP;

    public static long[] oneMinute(){
        return new long[]{System.currentTimeMillis() - ONE_MINUTE_TIMESTAMP, System.currentTimeMillis()};
    }

    public static long[] fiveMinutes(){
        long fiveMinutesBefore = System.currentTimeMillis() - ONE_MINUTE_TIMESTAMP * 5;
        return new long[]{fiveMinutesBefore, System.currentTimeMillis()};
    }
    public static long[] oneHour(){
        return new long[]{System.currentTimeMillis() - ONE_HOUR_TIMESTAMP, System.currentTimeMillis()};
    }
    public static long[] oneWeek(){
        return new long[]{System.currentTimeMillis() - ONE_WEEK_TIMESTAMP, System.currentTimeMillis()};
    }
    public static long[] oneMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        long oneMonthBefore = calendar.getTime().getTime();
        return new long[]{oneMonthBefore, System.currentTimeMillis()};
    }


    public static void main(String[] args) {
        Perso perso = new Perso();
        System.out.println(perso.getName());
    }

}
