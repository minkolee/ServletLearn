<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/2/19
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>测试JSP页面</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>


</head>
<body>
<%
    int i = 1 / 0;
%>
<h1><%="这是错误页面"%></h1>



</body>
</html>
