package com.goosuu.code12;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\1.txt"));
        String s = null;
        while((s = br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
    }
}
