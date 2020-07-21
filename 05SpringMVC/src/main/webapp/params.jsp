<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/17
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="param/testParam?username=wangwei&age=22">请求参数绑定测试-字符串</a>
    <form action="param/testDomainParam" method="post">
        开户名：<input type="text" name="name" value="">
        存款数：<input type="text" name="money" value="">
        用户姓名<input type="text" name="user.username" value="">
        用户年龄<input type="text" name="user.age" value="">
        <input type="submit" value="提交">
    </form>
    <br/>
    <form action="param/testCollectionParam" method="post">
        开户名：<input type="text" name="name" value="">
        存款数：<input type="text" name="money" value="">
        用户姓名<input type="text" name="user.username" value="">
        用户年龄<input type="text" name="user.age" value="">
        用户1姓名<input type="text" name="lists[0].username" value="">
        用户1年龄<input type="text" name="lists[0].age" value="">
        用户2姓名<input type="text" name="map['one'].username" value="">
        用户2年龄<input type="text" name="map['one'].age" value="">
        <input type="submit" value="提交">
    </form>
    <br/>
    <form action="param/testUser" method="post">
        姓名：<input type="text" name="username" value="">
        年龄：<input type="text" name="age" value="">
        出生日期:<input type="text" name="date" value="">
        <input type="submit" value="提交">
    </form>
    <br/>
    <a href="param/testServletApi">测试Servlet原生API</a>



</body>
</html>
