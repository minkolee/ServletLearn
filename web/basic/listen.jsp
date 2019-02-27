<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-26
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>监听器JSP</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <title>商品列表</title>
    <style>
        h1 {
            text-align: center;
            color: mediumvioletred;
        }
    </style>
</head>
<body>
<h1>测试监听器</h1>
<p><%=request.getAttribute("name")%></p>

</body>
</html>
