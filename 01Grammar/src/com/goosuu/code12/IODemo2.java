package com.goosuu.code12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo2 {
    public static void main(String[] args) {
       //读取数据
        try {
            FileInputStream fis = new FileInputStream(new File("D:\\1.txt"));
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
