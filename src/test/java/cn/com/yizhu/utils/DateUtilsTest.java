package cn.com.yizhu.utils;

import java.util.Date;

public class DateUtilsTest {
    public static void main(String[] args) {
        System.out.println("--------获取当前时间----------");
        System.out.println(DateUtils.getDate());
        System.out.println("--------获取当前时间----------");

        System.out.println("--------获取指定格式化的当前时间----------");
        System.out.println(DateUtils.getDate("HH:MM:ss.SSS"));
        System.out.println("--------获取指定格式化的当前时间----------");

        System.out.println("--------获取指定时间、指定格式化的时间----------");
        System.out.println(DateUtils.getDate(new Date(), "YYYY/MM/dd hh:mm:ss"));
        System.out.println("--------获取指定时间、指定格式化的时间----------");

        System.out.println("--------获取当前时间----------");
        System.out.println(DateUtils.getDateTime());
        System.out.println("--------获取当前时间----------");
    }
}
