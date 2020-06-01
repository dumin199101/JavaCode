package com.goosuu.code09;

/**
 *  包装类：
 *     装箱:基本数据类型变为包装类
 *           Integer Integer()
 *           static Integer ValueOf()
 *     拆箱:包装类转为基本数据类型
 *           intValue()
 *     基本数据类型---引用数据类型
 *     char      Character
 *     int       Integer
 *     byte      Byte
 *     short     Short
 *     long      Long
 *     boolean   Boolean
 *     float     Float
 *     double    Double
 *
 *    基本数据类型与包装类之间可以自动装箱，自动拆箱
 *
 *    包装类与字符串之间的转换：
 *       包装类---字符串：1.包装类静态方法toString() 2.String类的静态方法valueOf()
 *       字符串---包装类：使用包装类的parseInt
 *
 *
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //装箱
        Integer i = new Integer(10);
        Integer i2 = Integer.valueOf(100);
        System.out.println(i);
        System.out.println(i2);
        //拆箱
        System.out.println(i.intValue());
        //自动装箱
        Integer i3 = 1;
        System.out.println(i3);
        //自动拆箱：Integer自动调用intValue进行转换
        int result  = i3+4;
        System.out.println(result);
        //字符串--包装类型
        String s = "100";
        System.out.println(Integer.parseInt(s));
        //包装类变字符串
        String s2 = Integer.toString(12);
        System.out.println(s2);


    }
}
