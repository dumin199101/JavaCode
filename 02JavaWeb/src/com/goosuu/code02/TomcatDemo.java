package com.goosuu.code02;

/**
 *   Tomcat项目部署：
 *     1.直接部署：
 *       a.将项目打成war包,将war包放到webapps目录下,自动解压部署
 *         命令：jar -cvf war包名称 ./*
 *       b.直接将项目放到webapps目录下,通过虚拟目录方式访问
 *     2.配置conf/server.xml
 *       在Host标签下添加<Context docBase="D:\Song\hello" path="/tom" />
 *     3.热部署,无需重启(推荐方式)
 *       在conf/Catalina/localhost下创建*.xml,内容如下：
 *       <Context docBase="D:\Song\hello" />
 *       虚拟目录为xml文件名称
 *
 *     动态项目目录结构：
 *        根目录：
 *          WEB-INF
 *            web.xml:配置文件
 *            classes:存放字节码文件
 *            lib:存放jar包
 *
 *
 *
 *
 *
 */
public class TomcatDemo {
}
