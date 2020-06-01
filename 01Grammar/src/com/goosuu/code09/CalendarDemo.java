package com.goosuu.code09;

import java.util.Calendar;
import java.util.Date;

/**
 *  日历类Calendar：
 *     static Calendar getInstance():Calendar类无法直接创建对象
 *     Calendar get(int field)
 *     Calendar set(int field,int value)
 *     Calendar add(int field,int value)
 *     Date getTime()：日历转为日期
 *
 *
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        //获取
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH));  //月份从0-11
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        //设置
        instance.set(Calendar.YEAR,1992);
        instance.set(Calendar.MONTH,1);
        instance.set(Calendar.DATE,20);
        instance.set(2011,2,14);
        System.out.println(instance);
        //添加
        instance.add(Calendar.YEAR,4);
        System.out.println(instance);
        Date d = instance.getTime();
        System.out.println(d);

    }
}
