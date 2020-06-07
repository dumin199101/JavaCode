package com.goosuu.code12;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("控制台输出");
        PrintStream ps = new PrintStream("D:\\3.txt");
        ps.write(97);
        ps.print(97);
        System.setOut(ps);
        System.out.println("打印流输出");
        ps.close();

    }
}
