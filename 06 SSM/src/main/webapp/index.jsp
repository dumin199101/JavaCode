<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询账户</a>
    <h3>添加账户</h3>
    <form action="account/saveAccount" method="post">
        姓名：<input type="text" name="name"><br/>
        金钱：<input type="text" name="money"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
