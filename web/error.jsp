<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/2/19
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>


</head>
<body>
<h1><%="这是错误页面"%></h1>
<%
    // 虽然报错,但是是可以用的
    out.println("这事错误业务");
    out.write("这事错误业务");


%>


</body>
</html>
