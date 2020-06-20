<%@ page import="com.goosuu.code05.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/18
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My Tomcat</title>
  </head>
  <body>
  <h1>My Tomcat Service......</h1>
  <%
    User user = new User();
    user.setName("lisi");
    user.setAge(22);
    user.setDate(new Date());
    request.setAttribute("u",user);

    ArrayList<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);
    request.setAttribute("list",integers);
  %>
  ${requestScope.u.name}<br/>
  ${requestScope.list[1]}<br/>
  ${empty list}
  </body>
</html>
