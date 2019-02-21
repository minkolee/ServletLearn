<%@ page import="itemlist.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="itemlist.Good" %><%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-02-21
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private StringBuffer rowString(Good good) {
        StringBuffer strings = new StringBuffer();
        strings.append("<tr>");
        strings.append("<td>");
        strings.append(good.getId());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(good.getName());
        strings.append("</td>");
        strings.append("<td>");
        strings.append(good.getQuantity());
        strings.append("</td>");
        strings.append("</tr>");
        return strings;
    }
%>
<html>
<head>
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


<div class="container-fluid">
    <h1>商品列表</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">商品名称</th>
            <th scope="col">数量</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Good> lists = (List<Good>) request.getAttribute("products");
            for (Good p : lists) {
                pageContext.getOut().print(rowString(p));
            }
        %>
        </tbody>
    </table>
</div>


</body>
</html>
