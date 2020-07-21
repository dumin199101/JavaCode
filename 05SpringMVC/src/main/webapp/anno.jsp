<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/21
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <a href="anno/testRequestParam?name=lisi">测试RequestParam注解</a>
   <br/>
   <form action="anno/testRequestBody" method="post">
       用户名：<input type="text" name="username" value=""><br/>
       密码：<input type="text" name="password" value=""><br/>
       <input type="submit" value="提交">
   </form>
   <br/>
   <a href="anno/testPathVariable/100">测试PathVariable注解</a>
   <br/>
   <a href="anno/testCookieValue">测试CookieValue注解</a>
   <br/>
   <a href="anno/testRequestHeader">测试RequestHeader注解</a>
   <br/>
   <form action="anno/testModelAttribute" method="post">
       用户名：<input type="text" name="username" value=""><br/>
       密码：<input type="text" name="password" value=""><br/>
       <input type="submit" value="提交">
   </form>
   <br/>
   <form action="anno/testModelAttribute2" method="post">
       用户名：<input type="text" name="username" value=""><br/>
       年龄：<input type="text" name="age" value=""><br/>
       <input type="submit" value="提交">
   </form>
   <br/>
   <a href="anno/testSessionAttributes">testSessionAttributes</a>
   <a href="anno/getSessionAttributes">getSessionAttributes</a>
   <a href="anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
