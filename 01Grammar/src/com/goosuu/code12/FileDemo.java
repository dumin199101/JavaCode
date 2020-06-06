package com.goosuu.code12;

import java.io.File;

/**
 *   File类：
 *     构造方法：
 *        File(String pathname)
 *        File(File parent,String name)
 *        File(String parent,String name)
 *     普通方法：
 *        getPath()
 *        getAbsolutePath()
 *        getName()
 *        getParent()
 *        exists()
 *        isFile()
 *        isDirectory()
 *        delete()
 *        mkdir()
 *        mkdirs()
 *        createNewFile()
 *        renameTo()
 *        length():返回文件大小，单位字节
 *      遍历：
 *        String[] list()
 *        File[] listFiles()
 *
 *      文件过滤：
 *         listFiles(FileFilter filter):accept(File file)
 *         listFiles(FileNameFilter filter):accept(File file,String name)
 *
 *
 *
 *
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("F:\\长城");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName()+",大小为："+file1.length()+"字节");
        }


    }
}
