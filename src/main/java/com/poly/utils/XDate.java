package com.poly.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    /**
     * Chuyển đổi String sang Date
     *
     * @param date là String cần chuyển
     * @param patten là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String date, String patten) throws ParseException {

        formater.applyPattern(patten);
        return formater.parse(date);
    }

    /**
     * Chuyển đổi từ Date sang String
     *
     * @param date là Date cần chuyển đổi
     * @param patten là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String patten) {
        formater.applyPattern(patten);
        return formater.format(date);
    }

    /**
     * Bổ sung số ngày vào thời gian
     *
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}
