package com.goosuu.code03;
/**
 *  public static String toString():将数组转为字符串
 *  public static void sort():对数组元素从小到大排序，如果是字符串按照字母顺序排序
 */

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        String intStr = Arrays.toString(arr);
        System.out.println(intStr);
        int[] arr2 = {20, 2, 412, 1, 2421, 121, 12, 2};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
