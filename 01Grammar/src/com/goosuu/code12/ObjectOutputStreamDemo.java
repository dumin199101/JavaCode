package com.goosuu.code12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\2.txt"));
        Person p = new Person("小李", 22);
        oos.writeObject(p);
        oos.close();
    }
}
