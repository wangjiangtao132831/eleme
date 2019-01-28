package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/3 17:28
 */
public class DateUtils {
    static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    /**
     * 构造函数
     */
    public DateUtils() {
    }
    /**
     * 比较两个日期 返回值为两个日期的差
     * "2015-11-02","2015-11-03"
     * @return int
     * @param sDate1 java.lang.String
     * @param sDate2 java.lang.String
     */
    public static long compareDate(String sDate1, String sDate2) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse(sDate1);
            date2 = dateFormat.parse(sDate2);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in compareDate()");
            System.err.println("sDate1:" + sDate1);
            System.err.println("sDate2:" + sDate2);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }

        long dif = 0;
        long lDate2 = date2.getTime();
        long lDate1 = date1.getTime();

        dif = (lDate2 - lDate1) / 1000 / 60 / 60 / 24;
        return dif;
    }

    /**
     * 获取当前日期 格式为YYYYMMDD
     * @return java.lang.String
     */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(new Date());
        return s;
    }
    /**
     * 获取当前日期及时间 格式为YYYYMMDDHHmmss
     * @return java.lang.String
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = df.format(new Date());
        return s;
    }

    /**
     * 获取当前日期中的日
     * @return java.lang.String
     */
    public static String getCurrentDay() {
        String day;
        SimpleDateFormat df = new SimpleDateFormat("d");
        day = df.format(new Date());
        return day;
    }

    /**
     * 获取当前日期中的月
     * @return java.lang.String
     */
    public static String getCurrentMonth() {
        String month;
        SimpleDateFormat df = new SimpleDateFormat("M");
        month = df.format(new Date());
        return month;
    }

    /**
     * 获取当前时间 格式为YYYY-MM-DD HH:MM:SS
     * @return java.lang.String
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 获取当前日期中的年
     * @return java.lang.String
     */
    public static String getCurrentYear() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return df.format(new Date());
    }

    /**
     * 获取一个月前的一天
     * @return java.lang.String
     */
    public static String getDateBeforeAMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取一个月后的一天
     * @return String
     */
    public static String getDateAfterAMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取当前月的第一天
     * @return java.lang.String
     */
    public static String getFirstDateOfMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-");
        String s = df.format(new Date());
        s += "1";
        return s;
    }

    /**
     * 获取与当前日期相差若干天的日期
     * @return java.lang.String
     * @param dif int
     */
    public static String getDate(int dif) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与当前日期相差若干天的日期
     * @return java.lang.String
     * @param dif int
     */
    public static String getdifDate(int dif) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与指定日期相差若干天的日期
     * @return java.lang.String
     * @param aDate java.lang.String
     * @param dif int
     */
    public static String getDate(String aDate, int dif) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = null;
        try {
            date = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDate()");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与指定日期相差若干天的日期
     * @return java.lang.String
     * @param aDate java.lang.String
     * @param dif int
     */
    public static String getDatenew(String aDate, int dif) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = null;
        try {
            date = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDate()");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取指定日期一个月前的一天
     * @param aDate java.lang.String
     * @return java.lang.String
     */
    public static String getDateBeforeAMonth(String aDate) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        java.util.Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }
    //修改增加方法用于assistant.schedule--------begin------------->
    /**
     * 获取指定日期下个月的同一天
     * @param aDate String
     * @return java.lang.String
     */
    public static String getDateAfterMonth(String aDate) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        java.util.Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取指定日期下个月的某一天
     * @param aDate String
     * @param n int
     * @return java.util.Date
     */
    public static String getDateAfterMonth(String aDate, int n) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        java.util.Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, n);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    //修改增加方法用于assisitant.schedule---------end---------->
    /**
     * 获取当前日期后的一天
     * @return java.lang.String
     */
    public static String getNextDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取当前日期前的一天
     * @return java.lang.String
     */
    public static String getPreviousDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * Change date format.
     * From: yyyy-MM-dd   To: yyyy.MM.dd
     * @param oldValue String
     * @return String
     */
    public static String changeDateFormat(String oldValue) {
        String newValue = new String("2000.01.01");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat df = DateFormat.getDateInstance();
        Date temp = null;
        try {
            temp = df.parse(oldValue);
        } catch (ParseException e) {
            System.err.println(
                    "Catch invalid date format in method changeDateFormat(String oldValue) in class DateUtility.");
            System.err.println("Your input parameter:oldValue(" + oldValue + ")");
        }
        newValue = sdf.format(temp);
        return newValue;
    }

    /**
     * 由日期和时分秒来构成一个java.sql.Date
     * @param aDay String
     * @param aHour String
     * @param aMinute String
     * @param aSecond String
     * @return java.sql.Date
     */
    public static java.sql.Date constructDate(String aDay, String aHour, String aMinute, String aSecond) {
        java.sql.Date sDate = null;
        Date uDate = null;
        int hour, minute, second;
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            uDate = dateFormat.parse(aDay);
            hour = Integer.parseInt(aHour);
            minute = Integer.parseInt(aMinute);
            second = Integer.parseInt(aSecond);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println("aDay:" + aDay);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        uDate = calendar.getTime();
        sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    /**
     * @param aDay String
     * @return java.sql.Date
     */
    public static java.sql.Date constructDate(String aDay) {
        return constructDate(aDay, "0", "0", "0");
    }

    /**
     * 由日期和时分秒来构成一个java.sql.Timestamp
     * @param aDay String
     * @param aHour String
     * @param aMinute String
     * @param aSecond String
     * @return java.sql.Timestamp
     */
//    public static java.sql.Timestamp constructTimestamp(String aDay, String aHour, String aMinute, String aSecond) {
//        java.sql.Timestamp timestamp = null;
//        Date uDate = null;
//        int hour, minute, second;
//        DateFormat dateFormat = DateFormat.getDateInstance();
//        try {
//            uDate = dateFormat.parse(aDay);
//            hour = Integer.parseInt(aHour);
//            minute = Integer.parseInt(aMinute);
//            second = Integer.parseInt(aSecond);
//        } catch (ParseException e) {
//            System.err.println("Application log:Catch Exception in DateUtility");
//            System.err.println("aDay:" + aDay);
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//            return null;
//        } catch (NumberFormatException e) {
//            System.err.println("Application log:Catch Exception in DateUtility");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(uDate);
//        calendar.set(Calendar.HOUR_OF_DAY, hour);
//        calendar.set(Calendar.MINUTE, minute);
//        calendar.set(Calendar.SECOND, second);
//        uDate = calendar.getTime();
//        timestamp = new java.sql.Timestamp(uDate.getTime());
//        return timestamp;
//    }



    /**
     * 由日期来构成一个java.sql.Timestamp
     * 获取上个月的第一天
     * @return String
     */
    public static String getFirstDateOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-");
        String s = df.format(calendar.getTime());
        s += "01";
        return s;
    }

    /**
     * 获取上个月的最后一天
     * @return String
     * @throws Exception
     */
    public static String getLastDateOfLastMonth() throws Exception {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date uDate = null;
        try {
            uDate = dateFormat.parse(getFirstDateOfMonth());
        } catch (ParseException e) {
            System.err.println("Application log: Catch Exception in DateUtility");
            throw new Exception(e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取上年同期的日期
     * @param curBegin String
     * @param curEnd String
     * @return String[]
     */
    public static String[] getSameOfLastYear(String curBegin, String curEnd) {
        String[] last = new String[2];
        last[0] = (Integer.parseInt(curBegin.substring(0, 4)) - 1) + curBegin.substring(4);
        last[1] = (Integer.parseInt(curEnd.substring(0, 4)) - 1) + curEnd.substring(4);
        return last;
    }

    /**
     * 将日期转换为字符串
     * @param aDate java.util.Date
     * @param formatString 格式化字符串，如：yyyy-MM-dd
     * @return String
     */
    public static String formatDate(java.util.Date aDate,String formatString) {
        if(aDate == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 由日期获得星期(String)
     * @param s yyyy-MM-dd
     * @return EEE
     */
    public static String getDay(String s) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dayFormatter = new SimpleDateFormat("EEE");
        ParsePosition pos = new ParsePosition(0);
        Date giveDate = dateFormatter.parse(s, pos);
        return dayFormatter.format(giveDate).toString();
    }

    /**
     * 将日期由字符串转成日期型
     * @param s yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static Date getDateD(String s) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return dateFormatter.parse(s, pos);
    }

    /**
     * 将星期由字符串转成日期型
     * @param s EEE
     * @return EEE
     */
    public static Date getDayD(String s) {
        SimpleDateFormat dayFormatter = new SimpleDateFormat("EEE");
        ParsePosition pos = new ParsePosition(0);
        return dayFormatter.parse(s, pos);
    }

    /**
     * 将时间由字符串转成日期型
     * @param s HH:mm:ss
     * @return HH:mm:ss
     */
    public static Date getTimeD(String s) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return timeFormatter.parse(s, pos);
    }

    /**
     * @Title addDate
     * @Description 日期相加
     * @param start 开始时间(毫秒)
     * @param cycle 周期(天)
     * @return String
     */
    public static String addDate(long start, int cycle) {
        Calendar cd = Calendar.getInstance();
        cd.setTimeInMillis(start);
        cd.add(Calendar.DAY_OF_YEAR, cycle);
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cd.getTime());
    }

    /**
     * @Title isAfter
     * @Description 判断是否在当前时间之后
     * @param s
     * @return boolean
     */
    public static boolean isBefore(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            return false;
        }
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(d);
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        return now.before(endTime);
    }

    /**
     * @Title isAfter
     * @Description 判断现在是否在时间相加之后
     * @param s
     * @return boolean
     */
    public static boolean isBefore(String s, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            return false;
        }
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.add(Calendar.DATE, day);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(new Date());
        return now.after(endTime);
    }

    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        String s = df.format(new Date());
        return s;
    }

    /**
     * 获取
     * @param days
     * @return
     */
    public static String getAfterDayWithInt(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 0 - days);
        return df.format(calendar.getTime());
    }
}
