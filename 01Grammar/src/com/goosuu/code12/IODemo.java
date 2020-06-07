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
 *   转换流：
 *       作用：字节流转为字符流，可指定编码
 *       OutputStreamWriter(OutputStream out,Charset charset)
 *       InputStreamReader(InputStream in,Charset charset)
 *       编码表：
 *         ASCII：阿斯克码表
 *         IOS-8859-1:拉丁码表
 *         GB-2312:中文码表
 *         GBK：常用中文码表
 *         GB-18030：最新中文码表
 *         Unicode:Unicode码表，常用UTF-8
 *
 *   序列化流：
 *      序列化：将对象以流的方式写入文件保存
 *      反序列化：将文件中保存的对象以流的方式读取出来
 *      构造方法：
 *          ObjectOutputStream(OutputStream out)
 *          ObjectInputStream(InputStream in)
 *      必要条件：实现Serializable标记接口
 *      方法：
 *         readObject()
 *         writeObject()
 *      注意：
 *        transient:瞬态关键字
 *        当成员变量被static跟transient修饰时，不会被序列化
 *
 *      修改Person类文件，直接反序列化,由于Person.class与txt文件中serialVersionUID不一致报错，
 *      解决办法：生成固定serialVersionUID:private static final long serialVersionUID = 1L;
 *
 *    打印流：PrintStream继承自OutputStream下的FilterOutputStream
 *        构造方法：
 *          PrintStream(File file)
 *          PrintStream(OutputStream out)
 *        方法:
 *          print()
 *          println()
 *          write()
 *
 *        改变控制台输出：
 *           System.setOut(PrintStream ps)
 *
 *
 *
 *
 *
 *
 *
 *
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
