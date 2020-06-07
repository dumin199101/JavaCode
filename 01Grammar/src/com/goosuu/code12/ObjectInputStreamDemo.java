package com.goosuu.code12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\2.txt"));
        Object o = ois.readObject();
        ois.close();
        Person p = (Person) o;
        System.out.println(o);
        System.out.println(p.getName()+"---"+p.getAge());


    }
}
