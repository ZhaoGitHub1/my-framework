package cn.com.yizhu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
    // 默认日期格式化格式
    static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public DateUtils() {
    }

    /**
     * 获取yyyy-MM-dd格式当前时间
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        String formater = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        return format.format(date);
    }

    /**
     * 获取指定格式的的当前时间
     * @param formatStr
     * @return
     */
    public static String getDate(String formatStr) {
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(formatStr);
        return df.format(c.getTime());
    }

    /**
     * 获取指定格式的指定时间
     * @param date
     * @param formatStr
     * @return
     */
    public static String getDate(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr != null ? formatStr : DEFAULT_FORMAT);
        return date == null ? "" : format.format(date);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date getDateTime() {
        return getDateTime(getDate(DEFAULT_FORMAT));
    }

    /**
     * 获取字符串对应的的Date时间
     * @param dtime
     * @return
     */
    public static Date getDateTime(String dtime) {
        try {
            DateFormat format1 = new SimpleDateFormat(DEFAULT_FORMAT);
            return format1.parse(dtime);
        } catch (ParseException var2) {
            return null;
        }
    }

    /**
     * 获取指定格式的指定时间
     * @param dtime
     * @param formatStr
     * @return
     */
    public static Date getDateTime(String dtime, String formatStr) {
        try {
            DateFormat format1 = new SimpleDateFormat(formatStr);
            return format1.parse(dtime);
        } catch (ParseException var3) {
            return null;
        }
    }

    /**
     * 格式化日期为 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        return date == null ? null : format.format(getDateTime(date));
    }

    /**
     * 格式化日期为指定格式
     * @param date
     * @param formatStr
     * @return
     */
    public static String formatDate(String date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return date == null ? null : format.format(getDateTime(date));
    }

    /**
     * 获取sDate加iDay天之后sformat格式的时间
     * @param sDate
     * @param iDay
     * @param sformat
     * @return
     */
    public static String getSomeDate(String sDate, int iDay, String sformat) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(sformat);
            Date date = format.parse(sDate);
            long Time = date.getTime() / 1000L + (long)(86400 * iDay);
            date.setTime(Time * 1000L);
            return format.format(date);
        } catch (Exception var7) {
            return "";
        }
    }

    /**
     * 判断当前时间是否在btime和etime时间内
     * @param btime
     * @param etime
     * @return
     */
    public static boolean dateBound(String btime, String etime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = formatter.parse(btime, new ParsePosition(0));
        Date ed = formatter.parse(etime, new ParsePosition(0));
        return dateBound(sd, ed);
    }

    /**
     * 判断当前时间是否在sd和ed时间内
     * @param sd
     * @param ed
     * @return
     */
    public static boolean dateBound(Date sd, Date ed) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date td = formatter.parse(getDate(), new ParsePosition(0));
        if (sd != null && ed != null && td != null) {
            return sd.getTime() <= td.getTime() && ed.getTime() >= td.getTime();
        } else {
            return false;
        }
    }
}
