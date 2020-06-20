package com.goosuu.code05;

/**
 * EL表达式：
 *   语法：${表达式}
 *   作用：
 *     1.运算
 *       ${2+5}
 *     2.获取值
 *       只能从域对象中获取值
 *       语法：
 *         ${域名称.键名称}
 *         ${域名称.键名称[索引]}
 *         ${键名称} 依次从最小的域中查找
 *       pageScope  pageContext
 *       requestScope request
 *       sessionScope session
 *       applicationScope application
 *
 *      逻辑视图：
 *           ${requestScope.u.name}:访问name属性即调用getName()方法
 *
 *      empty运算符：
 *         判断对象是否为空并且长度是否为零
 *         ${not empty lists}
 *
 *      隐士对象：
 *         pageContext
 *         pageScope
 *         requestScope
 *         sessionScope
 *         applicationScope
 *
 *
 */
public class ELDemo {
}
