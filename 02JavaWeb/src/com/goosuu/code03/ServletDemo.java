package com.goosuu.code03;
/**
 *
 *  Servlet:
 *    定义：Servlet是一个接口，定义了Java类被浏览器访问的规则。
 *    实现Servlet接口,重写Servlet中的抽象方法
 *    配置Servlet：
 *       <servlet>
 *         <servlet-name>ServletDemo</servlet-name>
 *         <servlet-class>com.goosuu.code03.ServletDemo</servlet-class>
 *     </servlet>
 *
 *     <servlet-mapping>
 *         <servlet-name>ServletDemo</servlet-name>
 *         <url-pattern>/ServletDemo</url-pattern>
 *     </servlet-mapping>
 *
 *     Servlet生命周期：
 *        init():在Servlet第一次访问时被创建，只会被执行一次
 *            Servlet第一次访问时创建：
 *              <load-on-startup>负数</load-on-startup>
 *            服务器启动时创建：
 *              <load-on-startup>正数</load-on-startup>
 *        service():每一次Servlet被访问时都会执行
 *        destroy():在Servlet销毁时被执行,只会被执行一次
 *
 *     使用注解配置Servlet：
 *       @WebServlet()
 *
 *
 *
 *
 *
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hi")
public class ServletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Service...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroy...");
    }
}
