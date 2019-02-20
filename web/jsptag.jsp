<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-20
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 标签测试</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>
</head>
<body>
<%--与@page不同,jsp标签的include是动态包含--%>

<h1>这是动态包含了其他页面的地方</h1>

<jsp:include page="included.jsp" flush="false"/>








</body>
</html>
