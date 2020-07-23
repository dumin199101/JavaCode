<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/22
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
</head>
<body>
    <a href="response/testReturnString">返回值是字符串</a>
    <a href="response/testReturnVoid">返回值是空值</a>
    <a href="response/testReturnModelAndView">返回值是ModelAndView</a>
    <a href="response/testRedirectAndDispatcher">测试转发跟重定向</a>
    <button>ajax请求</button>
    <script>
        $("button").click(function(){
            $.ajax({
                url:"response/testJson",
                contentType:"application/json;charset=UTF-8",
                data:'{"username":"lisi","age":"22"}',
                type:"post",
                dataType:"json",
                success:function (data) {
                   alert(data.username);
                   alert(data.age);
                }
            })
        })
    </script>
</body>
</html>
