<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/23
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
   <h3>传统文件上传</h3>
   <form method="post" enctype="multipart/form-data" action="upload/uploadFile">
       姓名：<input type="text" name="username"><br/>
       文件上传：<input type="file" name="pic"><br/>
       <input type="submit" value="上传">
   </form>
   <h3>SpringMVC文件上传</h3>
   <form method="post" enctype="multipart/form-data" action="upload/uploadFile2">
       文件上传：<input type="file" name="upload"><br/>
       <input type="submit" value="上传">
   </form>
</body>
</html>
