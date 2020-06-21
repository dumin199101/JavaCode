<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goosuu.code05.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
    <%
       request.setAttribute("flag",true);
       request.setAttribute("week",1);
       ArrayList<User> users = new ArrayList<>();
       users.add(new User("lisi",22,new Date()));
       users.add(new User("wangwu",25,new Date()));
       users.add(new User("zhaoliu",27,new Date()));
       request.setAttribute("users",users);
    %>
    <c:if test="${flag}">
        <h1>Hello World</h1>
    </c:if>
    <c:choose>
        <c:when test="${week==1}">
            <h3>星期一</h3>
        </c:when>
        <c:when test="${week==2}">
            <h3>星期二</h3>
        </c:when>
        <c:when test="${week==3}">
            <h3>星期三</h3>
        </c:when>
        <c:when test="${week==4}">
            <h3>星期四</h3>
        </c:when>
        <c:when test="${week==5}">
            <h3>星期五</h3>
        </c:when>
        <c:when test="${week==6}">
            <h3>星期六</h3>
        </c:when>
        <c:when test="${week==7}">
            <h3>星期天</h3>
        </c:when>
        <c:otherwise>
            <h3>输入日期不对</h3>
        </c:otherwise>
    </c:choose>
    <c:forEach begin="1" end="3" step="1" var="i">
        <h4>${i}</h4>
    </c:forEach>
    <c:forEach items="${users}" var="user" varStatus="s">
        <h3>${s.index},${user.name},${s.count},${user.age}</h3>
    </c:forEach>


</body>
</html>
