package com.goosuu.code10;

import java.util.LinkedList;

/**
 *  LinkedList:
 *     底层双向链表，线程不同步，查询慢，增删快
 *  ArrayList
 *     底层数组，线程不同步，查询快，增删慢
 *  Vector
 *     底层数组，线程同步，查询快，增删慢
 *
 *
 *  LinkedList操作首尾元素：
 *    addFirst()
 *    addLast()
 *    removeFirst()
 *    removeLast()
 *    push():addFirst()
 *    pop():removeFirst()
 *    getFirst()
 *    getLast()
 *
 *
 *
 *
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("麦迪");
        list.add("姚明");
        list.add("科比");
        list.addFirst("邓肯");
        list.addLast("加内特");
        list.push("纳什");
        list.pop();
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
