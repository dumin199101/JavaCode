package com.goosuu.code03;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);
        int i2 = random.nextInt(10);
        System.out.println(i2);
    }
}
