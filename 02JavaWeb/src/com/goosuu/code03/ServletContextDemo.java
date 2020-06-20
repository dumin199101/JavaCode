package com.goosuu.code03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContext")
public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1= request.getServletContext();
        System.out.println(servletContext==servletContext1);
        System.out.println("**********************");
        String mimeType = servletContext.getMimeType("1.jpg");
        System.out.println(mimeType);
        System.out.println("*************************");
        servletContext.setAttribute("msg","hello");
        System.out.println("***********************");
        String realPath = servletContext.getRealPath("/index.jsp");
        System.out.println(realPath);

    }
}
