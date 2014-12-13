/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author woderchen
 */
public class DateHelper {

    /**
     *
     * 鏍煎紡鍖栬緭鍑烘棩鏈�
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @param format
     *
     * 鏍煎紡
     *
     * @return 杩斿洖瀛楃鍨嬫棩鏈�
     *
     */
    public static String format(java.util.Date date, String format) {
        String result = "";

        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);

                result = df.format(date);

            }
        } catch (Exception e) {
        }
        return result;

    }

    public static String format(java.util.Date date) {
        return format(date, "yyyy/MM/dd");

    }

    public static String formatTime(java.util.Date date) {
        return format(date, "yyyy/MM/dd HH:mm:ss");

    }

    /**
     * 瀛楃涓茶浆鎹㈡垚鏃ユ湡
     *
     * @param stringdate 瑕佽浆鎹㈢殑瀛楃涓�(瀛楃涓叉牸寮� yyyy-MM-dd)
     * @return
     */
    public static Date getStringtoDate(String stringdate) {
        Date dd = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date cDate;
        try {
            cDate = df.parse(stringdate);
            dd = new java.sql.Date(cDate.getTime());
        } catch (ParseException e1) {
        }
        return dd;
    }

    public static Date getStringtoTimestamp(String stringdate) {
        Date dd = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date cDate;
        try {
            cDate = df.parse(stringdate);
            dd = new java.sql.Date(cDate.getTime());
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return dd;
    }

    /**
     * 瀛楃涓茶浆鎹㈡垚鏃ユ湡
     *
     * @param stringdate 瑕佽浆鎹㈢殑瀛楃涓�
     * @param format 瀛楃涓茬殑鏃ユ湡鏍煎紡
     * @return
     */
    public static Date getStringtoDate(String stringdate, String format) {
        Date dd = null;
        Date cDate;
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            cDate = df.parse(stringdate);
            dd = new java.sql.Date(cDate.getTime());
        } catch (ParseException e1) {
        }
        return dd;
    }

    /**
     *
     * 杩斿洖骞翠唤
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖骞翠唤
     *
     */
    public static int getYear(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.YEAR);

    }

    /**
     *
     * 杩斿洖鏈堜唤
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖鏈堜唤
     *
     */
    public static int getMonth(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.MONTH) + 1;

    }

    /**
     *
     * 杩斿洖鏃ヤ唤
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖鏃ヤ唤
     *
     */
    public static int getDay(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.DAY_OF_MONTH);

    }

    /**
     *
     * 杩斿洖灏忔椂
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖灏忔椂
     *
     */
    public static int getHour(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.HOUR_OF_DAY);

    }

    /**
     *
     * 杩斿洖鍒嗛挓
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖鍒嗛挓
     *
     */
    public static int getMinute(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.MINUTE);

    }

    /**
     *
     * 杩斿洖绉掗挓
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖绉掗挓
     *
     */
    public static int getSecond(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.get(java.util.Calendar.SECOND);

    }

    /**
     *
     * 杩斿洖姣
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖姣
     *
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTime(date);

        return c.getTimeInMillis();

    }

    /**
     *
     * 杩斿洖瀛楃鍨嬫棩鏈�
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖瀛楃鍨嬫棩鏈�
     *
     */
    public static String getDate(java.util.Date date) {
        return format(date, "yyyy/MM/dd");

    }

    /**
     *
     * 杩斿洖瀛楃鍨嬫椂闂�
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖瀛楃鍨嬫椂闂�
     *
     */
    public static String getTime(java.util.Date date) {
        return format(date, "HH:mm:ss");

    }

    /**
     *
     * @param time
     * @return
     */
    public static String getDate(long time) {
        return formatTime((new Date(time)));
    }

    /**
     *
     * 杩斿洖瀛楃鍨嬫棩鏈熸椂闂�
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖瀛楃鍨嬫棩鏈熸椂闂�
     *
     */
    public static String getDateTime(java.util.Date date) {
        return format(date, "yyyy/MM/dd HH:mm:ss");

    }

    /**
     *
     * 鏃ユ湡鐩稿姞
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @param day
     *
     * 澶╂暟
     *
     * @return 杩斿洖鐩稿姞鍚庣殑鏃ユ湡
     *
     */
    public static java.util.Date addDate(java.util.Date date, int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();

        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);

        return c.getTime();

    }

    /**
     *
     * 鏃ユ湡鐩稿噺
     *
     *
     *
     * @param date
     *
     * 鏃ユ湡
     *
     * @param date1
     *
     * 鏃ユ湡
     *
     * @return 杩斿洖鐩稿噺鍚庣殑鏃ユ湡
     *
     */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));

    }

    public static Date currentDateAdd(int days) {
        // 鏃ユ湡澶勭悊妯″潡 (灏嗘棩鏈熷姞涓婃煇浜涘ぉ鎴栧噺鍘诲ぉ鏁�)杩斿洖瀛楃涓�
        Calendar canlendar = Calendar.getInstance(); // java.util鍖�
        canlendar.add(Calendar.DATE, days); // 鏃ユ湡鍑� 濡傛灉涓嶅鍑忎細灏嗘湀鍙樺姩
        return canlendar.getTime();
    }
}
