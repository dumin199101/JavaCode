package com.goosuu.code12;

import java.io.*;

/**
 *  IO流：
 *    1个字符 = 2个字节
 *            输入流(读取) 输出流(写入)
 *    字节流： InputStream OutputStream
 *    字符流： Reader      Writer
 *
 *    FileOutputStream(File file)
 *    FileOutputStream(File file,boolean append)
 *    FileOutputStream(String name)
 *    FileOutputStream(String name,boolean append)
 *    FileInputStream()
 *    FileReader()
 *    FileWriter()
 *
 *    输出流：
 *      write(int i)
 *      write(char[] chars)
 *      write(byte[] bytes)
 *      write(String s)
 *      newLine()
 *      flush()
 *      close()
 *    输入流：
 *      read(int i):一次读取一个字节，读取不到返回-1
 *      read(char[] chars)
 *      read(byte[] bytes):一次读取一个字节数组，读取不到返回-1，读取成功，返回数组长度，数据存储在字节数组bytes中
 *      close()
 *
 *   缓冲流：
 *       字节缓冲流：BufferedOutputStream(OutputStream out),BufferedInputStream(InputStream in)
 *       字符缓冲流:BufferedWriter(Writer out),BufferedReader(Reader in)
 *
 *
 *
 *
 */
public class IODemo {
    public static void main(String[] args) {
       //读取数据
        try {
            FileInputStream fis = new FileInputStream(new File("D:\\1.txt"));
            int len = 0;
            while((len = fis.read())!=-1){
                System.out.print((char)len);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
