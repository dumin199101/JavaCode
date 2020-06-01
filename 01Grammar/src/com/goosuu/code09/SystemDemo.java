package com.goosuu.code09;

import java.util.Arrays;

/**
 * System类：
 * CurrentTimeMillis()
 * arraycopy(src,int startPos,desc,int startPos,length)
 */

public class SystemDemo {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            sum += i;
        }
        long end_time = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(end_time - start_time);
        System.out.println("**************************");
        int[] src = new int[]{100,200,300};
        int[] dest = new int[]{1,2,3,4,5,6};
        System.arraycopy(src,0,dest,1,2);
        System.out.println(Arrays.toString(dest));  //[1, 100, 200, 4, 5, 6]
    }
}
