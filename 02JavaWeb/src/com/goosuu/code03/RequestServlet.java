package com.goosuu.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体
        BufferedReader reader = request.getReader();
        String str = null;
        while ((str = reader.readLine())!=null) {
            System.out.println(str);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求行
        String method = request.getMethod();
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL.toString());
        String queryString = request.getQueryString();
        System.out.println(queryString);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        String protocol = request.getProtocol();
        System.out.println(protocol);
        System.out.println("*******************");
        //获取请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }
        Enumeration<String> host = request.getHeaders("cookie");
        while (host.hasMoreElements()){
            System.out.println(host.nextElement());
        }
        System.out.println("**************************");
        Object city = request.getAttribute("city");
        System.out.println((String) city);



    }
}
