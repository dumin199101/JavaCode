package com.goosuu.code12;

import java.io.File;
import java.io.FileFilter;

/**
 *  用递归思想&文件过滤器查找以.js为后缀的文件
 *  用Lambda表达式实现
 *
 *
 *
 *
 */
public class FileFilterDemo3 {
    public static void main(String[] args) {
        File filepath = new File("F:\\迅雷下载\\jwplayer-8.0.13");
        getJsFile(filepath);
    }

    public static void getJsFile(File filepath){
        File[] files = filepath.listFiles((file)->file.isDirectory() || file.getName().toLowerCase().endsWith(".js"));

        for (File file : files) {
            if(file.isDirectory()){
                getJsFile(file);
            }else{
                System.out.println(file.getName());
            }
        }
    }
}
