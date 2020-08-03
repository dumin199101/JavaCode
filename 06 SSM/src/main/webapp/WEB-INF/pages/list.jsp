<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h3>查询所有账户信息</h3>
   <c:forEach items="${list}" var="item">
       <p><span>${item.name}</span><span>${item.money}</span></p>
   </c:forEach>
</body>
</html>
