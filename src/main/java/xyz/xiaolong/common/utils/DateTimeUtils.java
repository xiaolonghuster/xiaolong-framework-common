package xyz.xiaolong.common.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author lixiaolong
 * created by xlli5 on 2019/4/15 3:52 PM use IntelliJ IDEA
 */
public class DateTimeUtils {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_S2 = "yyyy-MM-dd HH:mm:ss.SSS";

    public DateTimeUtils() {
    }

    public static String now() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithMillisecond() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMddHHmmssSSS", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String timeWithMillisecond(long milliseconds) {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date(milliseconds));
    }

    public static String nowWithMillisecond2() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithSecond() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMddHHmmss", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithSecond2() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithMinute() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMddHHmm", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithHour() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMddHH", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String nowWithDay() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyyMMdd", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(new Date());
    }

    public static String format(String timeFormat, Date date) {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(timeFormat, TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.format(date);
    }

    public static String format(Date date) {
        if (date == null) {
            return "0000-00-00 00:00:00";
        } else {
            FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
            return fastDateFormat.format(date);
        }
    }

    public static Date parse(String date) throws ParseException {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        return fastDateFormat.parse(date);
    }

    public static long nowMilliSeconds() {
        return System.currentTimeMillis();
    }
}
