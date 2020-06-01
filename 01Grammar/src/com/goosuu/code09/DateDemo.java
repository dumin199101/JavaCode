package com.goosuu.code09;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Date日期时间类:
 *    long System.currentTimeMillis():当前系统毫秒值
 *    Date Date()
 *    Date Date(long millis)
 *    long getTime():返回系统日期毫秒值
 *
 *  日期格式化：
 *    SimpleDateFormat(pattern):java.util.text
 *    String format()格式化：日期---文本
 *    Date parse()解析：文本---日期
 *      抛出异常：ParseException
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        //获取当前系统毫秒值
        System.out.println(System.currentTimeMillis());
        // 毫秒转日期
        Date date = new Date();
        System.out.println(date); //Mon Jun 01 14:16:41 CST 2020
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);
        long millis = date1.getTime();
        System.out.println(millis);
        System.out.println("****************************");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = simpleDateFormat.format(date);
        System.out.println(d);
        Date date2 =  simpleDateFormat.parse("2020-05-02 12:12:33");
        System.out.println(date2);

    }

}
