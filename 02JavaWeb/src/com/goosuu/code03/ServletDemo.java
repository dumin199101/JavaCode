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
 *     Servlet体系结构：
 *       Servlet
 *          GenericServlet:Servlet接口中其他方法默认空实现，只对service方法做了抽象
 *             HttpServlet:重写了service方法，只需实现doGet()或doPost()即可
 *
 *    urlpattern路径定义规则：
 *      /xxx
 *      /xxx/xxx
 *      *.do
 *
 *    Request对象：
 *       ServletRequest
 *           HttpServletRequest
 *       获取请求行方法：
 *         getMethod()
 *         getContextPath():获取虚拟目录
 *         getServletPath():获取Servlet路径
 *         String getRequestURI():虚拟目录+Servlet路径
 *         StringBuffer getRequestURL():带协议+虚拟目录+Servlet路径
 *         getQueryString()
 *         getProtocol()
 *         getRemoteAddr()
 *       获取请求头方法：
 *         String getHeader(String name)
 *         Enumeration getHeaders(String name)
 *         Enumeration getHeaderNames()
 *           Enumeration迭代器：
 *              nextElement()
 *              hasMoreElements()
 *       获取请求体方法：
 *         BufferedReader getReader()
 *         ServletInputStream getInputStream()
 *
 *      其它功能：
 *        获取请求参数：
 *          String getParameter(String name)
 *          String[] getParameterValues(String name)
 *          Enumeration getParameterNames()
 *          Map<String,String> getParameterMap()
 *        设置编码：
 *          void setCharacterEncoding(String encode)
 *        请求转发：
 *           特点：
 *             1.地址栏没有发生变化,区别于重定向
 *             2.只能转发到当前服务器内部
 *             3.转发一次请求
 *           RequestDispatcher getRequestDispatcher()
 *              forward(request,response)
 *        共享数据：
 *          Request域：代表一次请求范围内
 *          getAttribute(String name)
 *          setAttribute(String name,Object o)
 *          removeAttribute(String name)
 *       获取ServletContext:
 *          ServletContext getServletContext()
 *
 *       BeanUtils:
 *         setProperty(Object o,String name,Object value)
 *         getProperty(Object o,String name)
 *         populate(Object o,Map m):将数据封装到JavaBean对象中
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
